package com.dev.spring.mvc.thymeleafdemo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev.spring.mvc.thymeleafdemo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query("SELECT e FROM Employee e WHERE " +
			"LOWER(e.firstName) LIKE LOWER(CONCAT('%', :keyword,'%')) OR " + 
			"LOWER(e.lastName) LIKE LOWER(CONCAT('%', :keyword,'%')) OR " +
			"LOWER(e.email) LIKE LOWER(CONCAT('%', :keyword,'%')) OR " +
			"LOWER(e.Education) LIKE LOWER(CONCAT('%', :keyword,'%'))") 

	List<Employee> search(@Param("keyword")String keyword);
}

