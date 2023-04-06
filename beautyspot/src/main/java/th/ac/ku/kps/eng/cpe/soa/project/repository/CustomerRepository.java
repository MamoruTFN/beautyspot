package th.ac.ku.kps.eng.cpe.soa.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.ac.ku.kps.eng.cpe.soa.project.model.Customer;
import th.ac.ku.kps.eng.cpe.soa.project.model.Reservation;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	@Query("select c from Reservation r inner join r.customer c where r = :reservation")
	public Customer findByReservation(@Param("reservation")Reservation reservation);
}
