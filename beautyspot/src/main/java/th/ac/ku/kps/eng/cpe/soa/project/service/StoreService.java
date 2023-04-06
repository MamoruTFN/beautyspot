package th.ac.ku.kps.eng.cpe.soa.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soa.project.model.Reservation;
import th.ac.ku.kps.eng.cpe.soa.project.model.Store;
import th.ac.ku.kps.eng.cpe.soa.project.model.Storeprice;
import th.ac.ku.kps.eng.cpe.soa.project.repository.StoreRepository;

@Service
public class StoreService {
	@Autowired
	private StoreRepository  storeRepository;
	
	public List<Store> findAll(){
		return (List<Store>) storeRepository.findAll();
	}
	
	public Store findById(int id) {
		return storeRepository.findById(id).get();
	}
	
	public void save(Store store) {
		storeRepository.save(store);
	}
	
	public void delete(Store store) {
		storeRepository.delete(store);
	}
	
	public Store findStoreByStoreprice(Storeprice storeprice) {
		return storeRepository.findStoreByStoreprice(storeprice);
	}
	
	public Store findByReservation(Reservation reservation) {
		return storeRepository.findByReservation(reservation);
	}
	
	public List<Store> rankingStoreByReservation(){
        return storeRepository.rankingByreservation();
    }
}
