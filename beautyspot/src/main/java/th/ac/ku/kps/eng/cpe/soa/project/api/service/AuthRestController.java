package th.ac.ku.kps.eng.cpe.soa.project.api.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import th.ac.ku.kps.eng.cpe.soa.project.api.util.JwtResponse;
import th.ac.ku.kps.eng.cpe.soa.project.api.util.Response;
import th.ac.ku.kps.eng.cpe.soa.project.model.User;
import th.ac.ku.kps.eng.cpe.soa.project.model.dto.LoginDTO;
import th.ac.ku.kps.eng.cpe.soa.project.model.dto.SignupDTO;
import th.ac.ku.kps.eng.cpe.soa.project.security.jwt.JwtUtils;
import th.ac.ku.kps.eng.cpe.soa.project.security.service.UserDetailsImpl;
import th.ac.ku.kps.eng.cpe.soa.project.service.AccountAlreadyExistException;
import th.ac.ku.kps.eng.cpe.soa.project.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthRestController {
	@Autowired
	private UserService userService;
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Response<ObjectNode>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Response<ObjectNode> res = new Response<>();
		res.setHttpStatus(HttpStatus.BAD_REQUEST);

		ObjectMapper mapper = new ObjectMapper();

		ObjectNode responObject = mapper.createObjectNode();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldname = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			responObject.put(fieldname, errorMessage);
		});
		res.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
		res.setBody(responObject);
		return new ResponseEntity<Response<ObjectNode>>(res, res.getHttpStatus());
	}

	@PostMapping("/signup")
	public ResponseEntity<Response<SignupDTO>> registerUser(@Valid @RequestBody SignupDTO user) {
		Response<SignupDTO> res = new Response<>();
		try {
			String roleName = "ROLE_Customer";
			User _user = new User();
			_user.signup(user);
			_user.setPwd(encoder.encode(_user.getPwd()));
			userService.registerNewAccount(_user, roleName);
			res.setMessage("Register Success");
			res.setBody(user);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<SignupDTO>>(res, res.getHttpStatus());
		} catch (AccountAlreadyExistException uaeEx) {
			res.setMessage("An account for that username/email already exists.");
			res.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Response<SignupDTO>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<SignupDTO>>(res, res.getHttpStatus());
		}
	}
	
	@PostMapping("/signup/staff")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('SystemAdmin')")
	public ResponseEntity<Response<SignupDTO>> registerStaff(@Valid @RequestBody SignupDTO user) {
		Response<SignupDTO> res = new Response<>();
		try {
			String roleName = "ROLE_Staff";
			User _user = new User();
			_user.signup(user);
			_user.setPwd(encoder.encode(_user.getPwd()));
			userService.registerNewAccount(_user, roleName);
			res.setMessage("Register Success");
			res.setBody(user);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<SignupDTO>>(res, res.getHttpStatus());
		} catch (AccountAlreadyExistException uaeEx) {
			res.setMessage("An account for that username/email already exists.");
			res.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Response<SignupDTO>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<SignupDTO>>(res, res.getHttpStatus());
		}
	}

	@PostMapping("/signin")
	public ResponseEntity<Response<JwtResponse>> authenticateUser(@Valid @RequestBody LoginDTO loginRequest) {
		Response<JwtResponse> res = new Response<>();
		UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
				loginRequest.getPassword());
		final Authentication authentication = authenticationManager.authenticate(authReq);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateToken(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		res.setBody(new JwtResponse(jwt, userDetails.getUsername(), roles));
		res.setHttpStatus(HttpStatus.OK);
		res.setMessage("ok");
		return new ResponseEntity<Response<JwtResponse>>(res, res.getHttpStatus());
	}

}
