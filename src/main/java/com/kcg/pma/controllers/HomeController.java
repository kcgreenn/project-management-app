package com.kcg.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kcg.pma.dao.IEmployeeRepository;
import com.kcg.pma.dao.IProjectRepository;
import com.kcg.pma.entities.Employee;
import com.kcg.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	IProjectRepository proRepo;
	@Autowired
	IEmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		// Get all projects and employees from database
		java.util.List<Project> projects = proRepo.findAll();
		java.util.List<Employee> employees = empRepo.findAll();
		// Map projects to template
		model.addAttribute("projects", projects);

		model.addAttribute("employees", employees);
		// Return the home page template
		return "main/home";
	}
}
