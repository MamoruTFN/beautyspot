package th.ac.ku.kps.eng.cpe.soa.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soa.project.model.Store;
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
}
