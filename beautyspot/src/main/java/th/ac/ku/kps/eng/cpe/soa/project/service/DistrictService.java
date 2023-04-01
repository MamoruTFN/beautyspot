package th.ac.ku.kps.eng.cpe.soa.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soa.project.model.District;
import th.ac.ku.kps.eng.cpe.soa.project.repository.DistrictRepository;

@Service
public class DistrictService {
	@Autowired
	private DistrictRepository districtRepository;
	
	public List<District> findAll(){
		return (List<District>) districtRepository.findAll();
	}
	
	public District findById(int id) {
		return districtRepository.findById(id).get();
	}
	
	public void save(District district) {
		districtRepository.save(district);
	}
	
	public void delete(District district) {
		districtRepository.delete(district);
	}
}
