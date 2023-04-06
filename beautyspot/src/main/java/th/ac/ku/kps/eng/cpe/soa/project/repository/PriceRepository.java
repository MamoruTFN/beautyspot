package th.ac.ku.kps.eng.cpe.soa.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import th.ac.ku.kps.eng.cpe.soa.project.model.Price;
import th.ac.ku.kps.eng.cpe.soa.project.model.Reservation;

public interface PriceRepository extends CrudRepository<Price, Integer> {
	@Query("select p from Reservation r inner join r.storeprice sp inner join sp.price p where r = :reservation")
	public Price findByReservation(@Param("reservation")Reservation reservation);
	
	@Query("select p from Price p inner join p.storeprices sp where sp.store.storeId = :storeId")
	public List<Price> findAllBystoreId(@Param("storeId")int storeId);
}
