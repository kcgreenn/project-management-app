package com.kcg.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kcg.pma.dao.IEmployeeRepository;
import com.kcg.pma.dto.EmployeeProject;
import com.kcg.pma.entities.Employee;

@Service
public class EmployeeService {
	@Autowired
	IEmployeeRepository employeeRepository;
	
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}
	
	public List<EmployeeProject> employeeProjects() {
		return employeeRepository.employeeProjects();
	}
}
