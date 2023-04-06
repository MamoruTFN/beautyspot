package th.ac.ku.kps.eng.cpe.soa.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soa.project.model.Reservation;
import th.ac.ku.kps.eng.cpe.soa.project.model.Store;
import th.ac.ku.kps.eng.cpe.soa.project.model.Storeprice;
import th.ac.ku.kps.eng.cpe.soa.project.repository.StorepriceRepository;

@Service
public class StorepriceService {
	@Autowired
	private StorepriceRepository storepriceRepository;
	
	public List<Storeprice> findAll(){
		return (List<Storeprice>) storepriceRepository.findAll();
	}
	
	public Storeprice findById(int id) {
		return storepriceRepository.findById(id).get();
	}
	
	public void save(Storeprice storeprice) {
		storepriceRepository.save(storeprice);
	}
	
	public void delete(Storeprice storeprice) {
		storepriceRepository.delete(storeprice);
	}
	
	public Storeprice findByReservation(Reservation reservation) {
		return storepriceRepository.findByReservation(reservation);
	}
	
}
