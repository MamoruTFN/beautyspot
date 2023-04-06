package th.ac.ku.kps.eng.cpe.soa.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.ac.ku.kps.eng.cpe.soa.project.model.Reservation;
import th.ac.ku.kps.eng.cpe.soa.project.model.Store;
import th.ac.ku.kps.eng.cpe.soa.project.model.Storeprice;

@Repository
public interface StorepriceRepository extends CrudRepository<Storeprice, Integer>{
	@Query("select sp from Reservation r inner join r.storeprice sp where r = :reservation")
	public Storeprice findByReservation (@Param("reservation")Reservation reservation);
}
