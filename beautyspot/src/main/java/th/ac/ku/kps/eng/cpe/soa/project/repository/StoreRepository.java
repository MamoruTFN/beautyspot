package th.ac.ku.kps.eng.cpe.soa.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.ac.ku.kps.eng.cpe.soa.project.model.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {

}
