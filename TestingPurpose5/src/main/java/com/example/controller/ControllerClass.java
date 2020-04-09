package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Employee;
import com.example.service.ServiceClass;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerClass {
	@Autowired
	ServiceClass serviceobj;

	// Create Employee
	@PostMapping("/EmployeeCreation")
	public String EmployeeCreation(@RequestBody Employee emp) {
		return serviceobj.EmployeeCreation(emp);
	}

	// Get Particular Employee Data
	@GetMapping("/GetEmployee/{id}")
	private Optional<Employee> getEmployee(@PathVariable("id") int id) {
		return serviceobj.getEmployeeById(id);
	}

	// Get All Employees Data
	@GetMapping("/GetAllEmployees")
	private List<Employee> getAllEmployee() {
		return serviceobj.getAllEmployee();

	}
	
	// Get Filtered Data
		@GetMapping("/GetFilter/{id}/{id1}")
		private Optional<Employee> GetFilter(@PathVariable("id") int id,@PathVariable("id1") int id1) {
			return serviceobj.GetFilter(id,id1);

		}

	// Updating Employee data
	@PutMapping("/UpdateEmployee")
	public String UpdateEmployee(@RequestBody Employee emp) {
		return serviceobj.UpdateEmployee(emp);

	}

	// Deleting Employee
	@DeleteMapping("/DeleteEmployee/{id}")
	private String delEmp(@PathVariable("id") int id) {
		return serviceobj.delete(id);
	}

}
