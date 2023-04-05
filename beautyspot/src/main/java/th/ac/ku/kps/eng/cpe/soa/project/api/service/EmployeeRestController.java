package th.ac.ku.kps.eng.cpe.soa.project.api.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import th.ac.ku.kps.eng.cpe.soa.project.api.util.Response;
import th.ac.ku.kps.eng.cpe.soa.project.model.Employee;
import th.ac.ku.kps.eng.cpe.soa.project.service.EmployeeService;

@CrossOrigin("http://localhost:8081/")
@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

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

	@PostMapping("/")
	public ResponseEntity<Response<Employee>> createReservation(@Valid @RequestBody Employee employee) {
		Response<Employee> res = new Response<>();
		try {
			employeeService.save(employee);
			res.setMessage("Create Success");
			res.setBody(employee);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Employee>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Employee>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<Employee>> findReservationById(@PathVariable("id") int id) {
		Response<Employee> res = new Response<>();
		try {
			Employee employee = employeeService.findById(id);
			res.setBody(employee);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Employee>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Employee>>(res, res.getHttpStatus());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response<Employee>> updateReservationById(@PathVariable("id") int id,
			@RequestBody Employee employee) {
		Response<Employee> res = new Response<>();
		try {
			Employee _employee = employeeService.findById(id);
			_employee.clone(employee);
			employeeService.save(employee);
			res.setMessage("update " + id + "success");
			res.setBody(employee);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Employee>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Employee>>(res, res.getHttpStatus());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response<String>> deleteReseevationById(@PathVariable("id") int id) {
		Response<String> res = new Response<String>();
		try {
			Employee user = employeeService.findById(id);
			employeeService.delete(user);
			res.setMessage("delete" + id + "success");
			res.setBody("");
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		}
	}

}
