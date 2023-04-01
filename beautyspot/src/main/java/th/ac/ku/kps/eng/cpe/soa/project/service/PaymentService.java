package th.ac.ku.kps.eng.cpe.soa.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soa.project.model.Payment;
import th.ac.ku.kps.eng.cpe.soa.project.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	
	public List<Payment> findAll(){
		return (List<Payment>) paymentRepository.findAll();
	}
	
	public Payment findById(int id) {
		return paymentRepository.findById(id).get();
	}
	
	public void save(Payment payment) {
		paymentRepository.save(payment);
	}
	
	public void delete(Payment payment) {
		paymentRepository.delete(payment);
	}
}
