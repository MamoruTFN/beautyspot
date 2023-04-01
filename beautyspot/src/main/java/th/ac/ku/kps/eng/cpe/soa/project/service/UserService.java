package th.ac.ku.kps.eng.cpe.soa.project.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import th.ac.ku.kps.eng.cpe.soa.project.model.Role;
import th.ac.ku.kps.eng.cpe.soa.project.model.User;
import th.ac.ku.kps.eng.cpe.soa.project.repository.UserRepository;
import th.ac.ku.kps.eng.cpe.soa.project.security.service.UserDetailsImpl;

@Service
@Transactional
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleService roleService;
	
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

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("Email not found in the database");
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		SimpleGrantedAuthority role = new SimpleGrantedAuthority(user.getRole().getName());
		authorities.add(role);
		return UserDetailsImpl.build(user);
	}
	
	private boolean emailExists(String email) {
		return userRepository.findByEmail(email) != null;
	}
	
	private boolean userNameExists(String userName) {
		return userRepository.findByName(userName) != null;
	}
	
	public void registerNewAccount(User user,String roleName) throws AccountAlreadyExistException{
		if (emailExists(user.getEmail())) {
            throw new AccountAlreadyExistException("There is an account with that email address: " + user.getEmail());
        }else if(userNameExists(user.getName())) {
        	throw new AccountAlreadyExistException("There is an account with that userName : " + user.getName());
        }
		else {
			Role role = roleService.findByName(roleName);
			user.setRole(role);
			save(user);
        }
	}
}
