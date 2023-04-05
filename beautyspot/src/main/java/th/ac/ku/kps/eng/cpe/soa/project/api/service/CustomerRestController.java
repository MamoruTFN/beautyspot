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
import th.ac.ku.kps.eng.cpe.soa.project.model.Customer;
import th.ac.ku.kps.eng.cpe.soa.project.service.CustomerService;

@CrossOrigin("http://localhost:8081/")
@RestController
@RequestMapping("/customers")
public class CustomerRestController {
	@Autowired
	private CustomerService customerService;

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
	public ResponseEntity<Response<Customer>> createReservation(@Valid @RequestBody Customer customer) {
		Response<Customer> res = new Response<>();
		try {
			customerService.save(customer);
			res.setMessage("Create Success");
			res.setBody(customer);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Customer>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Customer>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<Customer>> findReservationById(@PathVariable("id") int id) {
		Response<Customer> res = new Response<>();
		try {
			Customer customer = customerService.findById(id);
			res.setBody(customer);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Customer>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Customer>>(res, res.getHttpStatus());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response<Customer>> updateCustomerById(@PathVariable("id") int id,
			@RequestBody Customer customer) {
		Response<Customer> res = new Response<>();
		try {
			Customer _customer = customerService.findById(id);
			_customer.clone(customer);
			customerService.save(customer);
			res.setMessage("update " + id + "success");
			res.setBody(_customer);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Customer>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Customer>>(res, res.getHttpStatus());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response<String>> deleteReseevationById(@PathVariable("id") int id) {
		Response<String> res = new Response<String>();
		try {
			Customer user = customerService.findById(id);
			customerService.delete(user);
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
