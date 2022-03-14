package com.Employee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Employee.entity.Address;
import com.Employee.entity.Contact;
import com.Employee.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query("Select e.contact from Employee e where e.id = :empId ")
	public List<Contact> getContactDetailsById(@Param("empId") Long empId);
	
	@Query("Select e.address from Employee e where e.id = :empId")
	public List<Address> getAddressDetailsById(@Param("empId") Long empId);

}
