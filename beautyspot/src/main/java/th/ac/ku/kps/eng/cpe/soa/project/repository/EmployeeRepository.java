package th.ac.ku.kps.eng.cpe.soa.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.ac.ku.kps.eng.cpe.soa.project.model.Employee;



@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
}
