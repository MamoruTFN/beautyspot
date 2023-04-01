package th.ac.ku.kps.eng.cpe.soa.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.v3.oas.annotations.servers.Server;
import th.ac.ku.kps.eng.cpe.soa.project.model.Reservation;
import th.ac.ku.kps.eng.cpe.soa.project.repository.ReservationRepository;

@Server
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	
	public List<Reservation> findAll(){
		return (List<Reservation>) reservationRepository.findAll();
	}
	
	public Reservation findById(int id) {
		return reservationRepository.findById(id).get();
	}
	
	public void save(Reservation reservation) {
		reservationRepository.save(reservation);
	}
	
	public void delete(Reservation reservation) {
		reservationRepository.delete(reservation);
	}
}
