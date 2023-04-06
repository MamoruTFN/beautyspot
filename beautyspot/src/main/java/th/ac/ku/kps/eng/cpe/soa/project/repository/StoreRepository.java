package th.ac.ku.kps.eng.cpe.soa.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.ac.ku.kps.eng.cpe.soa.project.model.Reservation;
import th.ac.ku.kps.eng.cpe.soa.project.model.Store;
import th.ac.ku.kps.eng.cpe.soa.project.model.Storeprice;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {
	@Query("select s from Storeprice sp inner join sp.store s where sp = :storeprice")
	public Store findStoreByStoreprice(@Param("storeprice")Storeprice storeprice);
	
	@Query("select s from Reservation r inner join r.storeprice sp inner join sp.store s where r = :reservation")
	public Store findByReservation(@Param("reservation")Reservation reservation);
	
	@Query("select s from Store s inner join s.storeprices sp inner join sp.reservations r group by s order by count(r) DESC")
    public List<Store> rankingByreservation();
	
}
