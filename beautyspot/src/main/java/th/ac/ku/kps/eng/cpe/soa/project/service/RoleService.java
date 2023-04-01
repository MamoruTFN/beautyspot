package th.ac.ku.kps.eng.cpe.soa.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soa.project.model.Role;
import th.ac.ku.kps.eng.cpe.soa.project.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> findAll(){
		return (List<Role>) roleRepository.findAll();
	}
	
	public Role findById(int id) {
		return roleRepository.findById(id).get();
	}
	
	public void save(Role role) {
		roleRepository.save(role);
	}
	
	public void delete(Role role) {
		roleRepository.delete(role);
	}
	
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}
}
