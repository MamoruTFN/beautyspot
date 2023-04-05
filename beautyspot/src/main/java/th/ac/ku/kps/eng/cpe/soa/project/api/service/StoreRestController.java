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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import th.ac.ku.kps.eng.cpe.soa.project.api.util.Response;
import th.ac.ku.kps.eng.cpe.soa.project.model.Store;
import th.ac.ku.kps.eng.cpe.soa.project.model.Subdistrict;

import th.ac.ku.kps.eng.cpe.soa.project.service.StoreService;
import th.ac.ku.kps.eng.cpe.soa.project.service.SubdistrictService;

@RestController
@RequestMapping("/stores")
@CrossOrigin("http://localhost:8081/")
public class StoreRestController {
	@Autowired
	private StoreService storeService;
	@Autowired
	private SubdistrictService subdistrictService;
	
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
	public ResponseEntity<Response<Store>> findById(@PathVariable("id") int id) {
		Response<Store> res = new Response<>();
		try {
			Store store = storeService.findById(id);
			res.setMessage("find " + id + "success");
			res.setBody(store);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Store>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Store>>(res, res.getHttpStatus());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response<Store>> updateById(@PathVariable("id") int id,@RequestBody Store store) {
		Response<Store> res = new Response<>();
		try {
			Store _store = storeService.findById(id);
			_store.clone(store);
			storeService.save(_store);
			res.setMessage("update " + id + "success");
			res.setBody(_store);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Store>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Store>>(res, res.getHttpStatus());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<String>> deleteById(@PathVariable("id") int id){
		Response<String> res = new Response<>();
		try {
			Store store = storeService.findById(id);
			storeService.delete(store);
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
	public ResponseEntity<Response<Store>> createStore(@RequestParam("subdistrictId") int subdistrictId,
			@Valid@RequestBody Store store){
		Response<Store> res = new Response<>();
		try {
			Subdistrict subdistrict = subdistrictService.findById(subdistrictId);
			store.setSubdistrict(subdistrict);
			storeService.save(store);
			res.setMessage("Create Success");
			res.setBody(store);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Store>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Store>>(res, res.getHttpStatus());
		}
	}
	
}