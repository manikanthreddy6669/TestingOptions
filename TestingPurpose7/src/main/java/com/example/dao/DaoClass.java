package com.example.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;
@Repository
public interface DaoClass extends JpaRepository<Employee, Integer> {

	@Query("select id,name,salary from Employee where salary between ?1 and ?2")
	Optional<Employee> GetFilter(@Param("id") int id,@Param("id") int id1);

	
}
