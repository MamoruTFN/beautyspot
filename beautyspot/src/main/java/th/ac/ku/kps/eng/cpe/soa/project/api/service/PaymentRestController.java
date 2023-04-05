package th.ac.ku.kps.eng.cpe.soa.project.api.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.FieldError;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import th.ac.ku.kps.eng.cpe.soa.project.api.util.Response;
import th.ac.ku.kps.eng.cpe.soa.project.model.Customer;
import th.ac.ku.kps.eng.cpe.soa.project.model.Payment;
import th.ac.ku.kps.eng.cpe.soa.project.model.Promotion;
import th.ac.ku.kps.eng.cpe.soa.project.model.Reservation;
import th.ac.ku.kps.eng.cpe.soa.project.service.PaymentService;
import th.ac.ku.kps.eng.cpe.soa.project.service.PromotionService;
import th.ac.ku.kps.eng.cpe.soa.project.service.ReservationService;
import th.ac.ku.kps.eng.cpe.soa.project.service.CustomerService;
import th.ac.ku.kps.eng.cpe.soa.project.service.EmployeeService;

@RestController
@RequestMapping("/payments")
@CrossOrigin("http://localhost:8081/")
public class PaymentRestController {
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private PromotionService promotionService;
	@Autowired
	private ReservationService reservationService;
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

	@GetMapping("/{id}")
	public ResponseEntity<Response<Payment>> findById(@PathVariable("id") int id) {
		Response<Payment> res = new Response<>();
		try {
			Payment payment = paymentService.findById(id);
			res.setMessage("find " + id + "success");
			res.setBody(payment);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Payment>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Payment>>(res, res.getHttpStatus());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response<Payment>> updateById(@PathVariable("id") int id, @RequestBody Payment payment) {
		Response<Payment> res = new Response<>();
		try {
			Payment _payment = paymentService.findById(id);
			_payment.clone(payment);
			paymentService.save(_payment);
			res.setMessage("update " + id + "success");
			res.setBody(payment);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Payment>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Payment>>(res, res.getHttpStatus());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response<String>> deleteById(@PathVariable("id") int id) {
		Response<String> res = new Response<>();
		try {
			Payment payment = paymentService.findById(id);
			paymentService.delete(payment);
			res.setMessage("delete " + id + "success");
			res.setBody("");
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		}
	}

	@PostMapping("/")
	public ResponseEntity<Response<Payment>> createPayment(@RequestParam("promotionId") int promotionId,
			@RequestParam("reservationId") int reservationId, @RequestParam("customer") int customerId,
			@Valid @RequestBody Payment payment) {
		Response<Payment> res = new Response<>();
		try {
			Promotion promotion = promotionService.findById(promotionId);
			Reservation reservation = reservationService.findById(reservationId);
			Customer customer = customerService.findById(customerId);
			payment.setPromotion(promotion);
			payment.setReservation(reservation);
			payment.setCustomer(customer);
			paymentService.save(payment);
			res.setMessage("Create Success");
			res.setBody(payment);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Payment>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Payment>>(res, res.getHttpStatus());
		}
	}

}
