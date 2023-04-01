package th.ac.ku.kps.eng.cpe.soa.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.ac.ku.kps.eng.cpe.soa.project.model.Subdistrict;

@Repository
public interface SubdistrictRepository extends CrudRepository<Subdistrict, Integer> {

}
