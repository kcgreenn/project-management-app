package com.kcg.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kcg.pma.dao.IEmployeeRepository;
import com.kcg.pma.entities.Employee;
import com.kcg.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
//	IEmployeeRepository empRepo;
	
	@GetMapping("")
	public String displayEmployeeHome(Model model) {
		// Get all employee data
		java.util.List<Employee> employees = employeeService.getAll();
		// Map employees to template
		model.addAttribute("employees", employees);
		// Return employee home template
		return "employees/main";
	}
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		// Create new employee with default constructor
		Employee anEmployee = new Employee();
		// Get user input for new employee attributes
		model.addAttribute("employee", anEmployee);
		// Serve new employee form page
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		// Save employee to database
		employeeService.save(employee);
		// Redirect to prevent duplicate submissions
		return "redirect:/employees/new";
	}
}
