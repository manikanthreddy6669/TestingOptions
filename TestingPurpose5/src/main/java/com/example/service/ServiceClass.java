package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Employee;
import com.example.dao.DaoClass;

@Service
@Transactional
public class ServiceClass {
	@Autowired
	DaoClass dao;

	public String EmployeeCreation(Employee emp) {
		dao.save(emp);
		return "Employee created successfully";
	}

	public Optional<Employee> getEmployeeById(int id) {
		return dao.findById(id);
	}

	public List<Employee> getAllEmployee() {
		List<Employee> emps = dao.findAll();
		return emps;
	}

	public String delete(int id) {
		boolean b = dao.existsById(id);
		if (b) {
			dao.deleteById(id);
			return "Deleted Employee Successfully!";
		} else
			return "Provided Employee id was not found";
	}

	public String UpdateEmployee(Employee emp) {
		boolean b = dao.existsById(emp.getId());
		if (b) {
			dao.save(emp);
			return "Updated Employee Info Successfully!";
		} else
			return "Provided Employee id was not found";

	}

	public Optional<Employee> GetFilter(int id,int id1) {
		return dao.GetFilter(id,id1);
	}
}