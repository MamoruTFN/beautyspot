package th.ac.ku.kps.eng.cpe.soa.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.ac.ku.kps.eng.cpe.soa.project.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
	@Query("from Role r where r.name = :name")
	public Role findByName(@Param("name")String name);
}
