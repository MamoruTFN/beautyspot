package th.ac.ku.kps.eng.cpe.soa.project.api.service;

import java.util.ArrayList;
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

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import th.ac.ku.kps.eng.cpe.soa.project.api.util.Response;
import th.ac.ku.kps.eng.cpe.soa.project.model.District;
import th.ac.ku.kps.eng.cpe.soa.project.model.Promotion;
import th.ac.ku.kps.eng.cpe.soa.project.model.Province;
import th.ac.ku.kps.eng.cpe.soa.project.model.Store;
import th.ac.ku.kps.eng.cpe.soa.project.model.Subdistrict;
import th.ac.ku.kps.eng.cpe.soa.project.model.DTO.StoreDTO;
import th.ac.ku.kps.eng.cpe.soa.project.service.PromotionService;

@RestController
@RequestMapping("/promotions")
@CrossOrigin("http://localhost:8081/")
public class PromotionRestController {
	@Autowired
	private PromotionService promotionService;

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
	
	@GetMapping("/")
	public ResponseEntity<Response<List<Promotion>>> findAll(){
		Response<List<Promotion>> res = new Response<>();
		try {
			List<Promotion> stores = promotionService.findAll();
			res.setMessage("find success");
			res.setBody(stores);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<List<Promotion>>>(res, res.getHttpStatus());
		}catch (Exception ex) {
			res.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<List<Promotion>>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<Promotion>> findById(@PathVariable("id") int id) {
		Response<Promotion> res = new Response<>();
		try {
			Promotion promotion = promotionService.findById(id);
			res.setMessage("find " + id + "success");
			res.setBody(promotion);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Promotion>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Promotion>>(res, res.getHttpStatus());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response<Promotion>> updateById(@PathVariable("id") int id, @RequestBody Promotion promotion) {
		Response<Promotion> res = new Response<>();
		try {
			Promotion _promotion = promotionService.findById(id);
			_promotion.clone(promotion);
			promotionService.save(_promotion);
			res.setMessage("update " + id + "success");
			res.setBody(_promotion);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Promotion>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Promotion>>(res, res.getHttpStatus());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response<String>> deleteById(@PathVariable("id") int id) {
		Response<String> res = new Response<>();
		try {
			Promotion promotion = promotionService.findById(id);
			promotionService.delete(promotion);
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
	public ResponseEntity<Response<Promotion>> createPromotion(@Valid @RequestBody Promotion promotion) {
		Response<Promotion> res = new Response<>();
		try {
			promotionService.save(promotion);
			res.setMessage("Create Success");
			res.setBody(promotion);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Promotion>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Promotion>>(res, res.getHttpStatus());
		}
	}

}
