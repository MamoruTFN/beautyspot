package th.ac.ku.kps.eng.cpe.soa.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soa.project.model.Price;
import th.ac.ku.kps.eng.cpe.soa.project.model.Reservation;
import th.ac.ku.kps.eng.cpe.soa.project.repository.PriceRepository;

@Service
public class PriceService {
	@Autowired
	private PriceRepository priceRepository;

	public List<Price> findAll(){
		return (List<Price>) priceRepository.findAll();
	}
	
	public List<Price> findAllByStoreId(int storeId){
		return (List<Price>) priceRepository.findAllBystoreId(storeId);
	}
	
	public Price findById(int id) {
		return priceRepository.findById(id).get();
	}
	
	public void save(Price price) {
		priceRepository.save(price);
	}
	
	public void delete(Price price) {
		priceRepository.delete(price);
	}
	
	public Price findByReservation(Reservation reservation) {
		return priceRepository.findByReservation(reservation);
	}
}
