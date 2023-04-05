package th.ac.ku.kps.eng.cpe.soa.project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soa.project.model.Employee;

import th.ac.ku.kps.eng.cpe.soa.project.repository.EmployeeRepository;


@Service
public class EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> findAll(){
		return (List<Employee>) employeeRepository.findAll();
	}
	
	public Employee findById(int id) {
		return employeeRepository.findById(id).get();
	}
	
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void delete(Employee employee) {
		employeeRepository.delete(employee);
	}
	
}
