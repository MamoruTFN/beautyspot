package th.ac.ku.kps.eng.cpe.soa.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.ac.ku.kps.eng.cpe.soa.project.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	@Query("from User u where u.email = :email")
	public User findByEmail (@Param("email")String email);
	
	@Query("from User u where u.name = :name")
	public User findByName(@Param("name")String name);
}
