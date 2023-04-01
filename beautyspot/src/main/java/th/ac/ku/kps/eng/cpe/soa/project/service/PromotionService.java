package th.ac.ku.kps.eng.cpe.soa.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soa.project.model.Promotion;
import th.ac.ku.kps.eng.cpe.soa.project.repository.PromotionRepository;

@Service
public class PromotionService {
	@Autowired
	private PromotionRepository promotionRepository;
	
	public List<Promotion> findAll(){
		return (List<Promotion>) promotionRepository.findAll();
	}
	
	public Promotion findById(int id) {
		return promotionRepository.findById(id).get();
	}
	
	public void save(Promotion promotion) {
		promotionRepository.save(promotion);
	}
	
	public void delete(Promotion promotion) {
		promotionRepository.delete(promotion);
	}
}
