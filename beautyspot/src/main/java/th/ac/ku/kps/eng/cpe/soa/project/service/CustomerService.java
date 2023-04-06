package th.ac.ku.kps.eng.cpe.soa.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soa.project.model.Customer;
import th.ac.ku.kps.eng.cpe.soa.project.model.Reservation;
import th.ac.ku.kps.eng.cpe.soa.project.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> findAll(){
		return (List<Customer>) customerRepository.findAll();
	}
	
	public Customer findById(int id) {
		return customerRepository.findById(id).get();
	}
	
	public void save(Customer customer) {
		customerRepository.save(customer);
	}
	
	public void delete(Customer customer) {
		customerRepository.delete(customer);
	}

	public Customer findByReservation(Reservation reservation) {
		return customerRepository.findByReservation(reservation);
	}
	
}
