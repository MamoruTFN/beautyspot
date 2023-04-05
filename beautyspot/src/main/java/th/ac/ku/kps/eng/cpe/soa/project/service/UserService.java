package th.ac.ku.kps.eng.cpe.soa.project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.ku.kps.eng.cpe.soa.project.model.User;
import th.ac.ku.kps.eng.cpe.soa.project.repository.UserRepository;


@Service
public class UserService{
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return (List<User>) userRepository.findAll();
	}
	
	public User findById(int id) {
		return userRepository.findById(id).get();
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	public User findByEmail (String email) {
		return userRepository.findByEmail(email);
	}
}
