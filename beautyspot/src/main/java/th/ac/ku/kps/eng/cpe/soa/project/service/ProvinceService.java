package th.ac.ku.kps.eng.cpe.soa.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soa.project.model.Province;
import th.ac.ku.kps.eng.cpe.soa.project.repository.ProvinceRepository;

@Service
public class ProvinceService {
	@Autowired
	private ProvinceRepository provinceRepository;
	
	public List<Province> findAll(){
		return (List<Province>) provinceRepository.findAll();
	}
	
	public Province findById(int id) {
		return provinceRepository.findById(id).get();
	}
	
	public void save(Province province) {
		provinceRepository.save(province);
	}
	
	public void delete(Province province) {
		provinceRepository.delete(province);
	}
}
