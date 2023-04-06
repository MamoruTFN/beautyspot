package th.ac.ku.kps.eng.cpe.soa.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.ac.ku.kps.eng.cpe.soa.project.model.Promotion;
import th.ac.ku.kps.eng.cpe.soa.project.model.Reservation;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion, Integer> {
	@Query("select p from Reservation r inner join r.promotion p where r = :reservation")
	public Promotion findByReservation (@Param("reservation")Reservation reservation);
}
