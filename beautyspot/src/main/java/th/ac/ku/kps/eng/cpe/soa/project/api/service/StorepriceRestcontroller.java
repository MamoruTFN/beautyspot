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
import th.ac.ku.kps.eng.cpe.soa.project.model.Price;
import th.ac.ku.kps.eng.cpe.soa.project.model.Storeprice;
import th.ac.ku.kps.eng.cpe.soa.project.model.DTO.StorePriceDTO;
import th.ac.ku.kps.eng.cpe.soa.project.service.PriceService;
import th.ac.ku.kps.eng.cpe.soa.project.service.StorepriceService;

@RestController
@RequestMapping("/storeprice")
@CrossOrigin("http://localhost:8081/")
public class StorepriceRestcontroller {
	@Autowired
	private StorepriceService storepriceService;
	
	@Autowired
	private PriceService priceService;
	
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
	public ResponseEntity<Response<Storeprice>> createReservation(@Valid @RequestBody Storeprice storeprice) {
		Response<Storeprice> res = new Response<>();
		try {
			storepriceService.save(storeprice);
			res.setMessage("Create Success");
			res.setBody(storeprice);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Storeprice>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Storeprice>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<Storeprice>> findReservationById(@PathVariable("id") int id) {
		Response<Storeprice> res = new Response<>();
		try {
			Storeprice storeprice = storepriceService.findById(id);
			res.setBody(storeprice);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Storeprice>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Storeprice>>(res, res.getHttpStatus());
		}
	}
	
	@GetMapping("/price/{id}")
	public ResponseEntity<Response<List<StorePriceDTO>>> findAllPriceByStoreId(@PathVariable("id") int id) {
		Response<List<StorePriceDTO>> res = new Response<>();
		try {
			List<Storeprice> storeprice = storepriceService.findAll();
			List<StorePriceDTO> storePriceDTOs = new ArrayList<StorePriceDTO>();
			for(Storeprice sp:storeprice) {
				if(sp.getStore().getStoreId() == id) {
					StorePriceDTO spd = new StorePriceDTO();
				int priceId = sp.getPrice().getPriceId();
				Price p = priceService.findById(priceId);
				spd.setName(p.getName());
				spd.setPrice(p.getAmount());
				spd.setStorePriceId(sp.getStorepriceId());
				storePriceDTOs.add(spd);
				}
			}
			res.setBody(storePriceDTOs);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<List<StorePriceDTO>>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<List<StorePriceDTO>>>(res, res.getHttpStatus());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response<Storeprice>> updateReservationById(@PathVariable("id") int id,
			@RequestBody Storeprice storeprice) {
		Response<Storeprice> res = new Response<>();
		try {
			Storeprice _storeprice = storepriceService.findById(id);
			_storeprice.clone(storeprice);
			storepriceService.save(_storeprice);
			res.setMessage("update " + id + "success");
			res.setBody(_storeprice);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Storeprice>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Storeprice>>(res, res.getHttpStatus());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response<String>> deleteById(@PathVariable("id") int id) {
		Response<String> res = new Response<String>();
		try {
			Storeprice storeprice = storepriceService.findById(id);
			storepriceService.delete(storeprice);
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
