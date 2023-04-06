package th.ac.ku.kps.eng.cpe.soa.project.api.service;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import th.ac.ku.kps.eng.cpe.soa.project.api.util.Response;
import th.ac.ku.kps.eng.cpe.soa.project.model.Customer;
import th.ac.ku.kps.eng.cpe.soa.project.model.Payment;
import th.ac.ku.kps.eng.cpe.soa.project.model.Promotion;
import th.ac.ku.kps.eng.cpe.soa.project.model.Reservation;
import th.ac.ku.kps.eng.cpe.soa.project.model.Store;
import th.ac.ku.kps.eng.cpe.soa.project.model.Storeprice;
import th.ac.ku.kps.eng.cpe.soa.project.model.DTO.ReservationDTO;
import th.ac.ku.kps.eng.cpe.soa.project.service.PromotionService;
import th.ac.ku.kps.eng.cpe.soa.project.service.ReservationService;
import th.ac.ku.kps.eng.cpe.soa.project.service.StoreService;
import th.ac.ku.kps.eng.cpe.soa.project.service.StorepriceService;
import th.ac.ku.kps.eng.cpe.soa.project.service.CustomerService;
import th.ac.ku.kps.eng.cpe.soa.project.service.EmployeeService;
import th.ac.ku.kps.eng.cpe.soa.project.service.PaymentService;

@CrossOrigin("http://localhost:8081/")
@RestController
@RequestMapping("/reservations")
public class ReservationRestController {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private PromotionService promotionService;

	@Autowired
	private CustomerService customerService;
	@Autowired
	private StorepriceService storepriceService;

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
	public ResponseEntity<Response<Reservation>> createReservation(@Valid @RequestBody ReservationDTO reservationDTO,
			@RequestParam("storepriceId") int storepriceId, @RequestParam("promotionId") int promotionId) {
		Response<Reservation> res = new Response<>();
		try {
			Reservation reservation = new Reservation();
			Customer customer = new Customer();
			customer.cloneDto(reservationDTO);
			customerService.save(customer);
			Storeprice storeprice = storepriceService.findById(storepriceId);
			Promotion promotion = promotionService.findById(promotionId);
			reservation.cloneDto(reservationDTO);
			reservation.setCustomer(customer);
			reservation.setPromotion(promotion);
			reservation.setStoreprice(storeprice);
			
			reservationService.save(reservation);
			
			res.setMessage("Create Success");
			res.setBody(reservation);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Reservation>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Reservation>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<Reservation>> findReservationById(@PathVariable("id") int id) {
		Response<Reservation> res = new Response<>();
		try {
			Reservation reservation = reservationService.findById(id);
			res.setBody(reservation);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Reservation>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Reservation>>(res, res.getHttpStatus());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response<Reservation>> updateReservationById(@PathVariable("id") int id,
			@RequestBody Reservation reservation) {
		Response<Reservation> res = new Response<>();
		try {
			Reservation r = reservationService.findById(id);
			r.clone(reservation);
			reservationService.save(r);
			res.setMessage("update " + id + "success");
			res.setBody(r);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Reservation>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Reservation>>(res, res.getHttpStatus());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response<String>> deleteReseevationById(@PathVariable("id") int id) {
		Response<String> res = new Response<String>();
		try {
			Reservation reservation = reservationService.findById(id);
			reservationService.delete(reservation);
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
	
	@GetMapping("/max")
	public ResponseEntity<Response<Reservation>> findReservationByIdMax() {
		Response<Reservation> res = new Response<>();
		try {
			List<Reservation> reservations = reservationService.findAll();
			Reservation reservation = new Reservation();
			int id = 1;
			for(Reservation r : reservations) {
				if(r.getReservationId() >= id) {
					id = r.getReservationId();
					reservation = r;
				}
			}
			res.setBody(reservation);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Reservation>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Reservation>>(res, res.getHttpStatus());
		}
	}
}
