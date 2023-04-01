package th.ac.ku.kps.eng.cpe.soa.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soa.project.model.Subdistrict;
import th.ac.ku.kps.eng.cpe.soa.project.repository.SubdistrictRepository;

@Service
public class SubdistrictService {
	@Autowired
	private SubdistrictRepository subdistrictRepository;
	
	public List<Subdistrict> findAll(){
		return (List<Subdistrict>) subdistrictRepository.findAll();
	}
	
	public Subdistrict findById(int id) {
		return subdistrictRepository.findById(id).get();
	}
	
	public void save(Subdistrict subdistrict) {
		subdistrictRepository.save(subdistrict);
	}
	
	public void delete(Subdistrict subdistrict) {
		subdistrictRepository.delete(subdistrict);
	}
}
