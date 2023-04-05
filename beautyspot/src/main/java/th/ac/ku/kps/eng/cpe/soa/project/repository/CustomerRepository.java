package th.ac.ku.kps.eng.cpe.soa.project.repository;

import org.springframework.data.repository.CrudRepository;

import th.ac.ku.kps.eng.cpe.soa.project.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
