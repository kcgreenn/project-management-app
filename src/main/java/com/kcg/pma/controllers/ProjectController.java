package com.kcg.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kcg.pma.entities.Employee;
import com.kcg.pma.entities.Project;
import com.kcg.pma.services.EmployeeService;
import com.kcg.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
//	IProjectRepository proRepo;
	
	@Autowired
	EmployeeService employeeService;
//	IEmployeeRepository empRepo;
	
	@GetMapping("")
	public String displayProjectHome(Model model) {
		// Get all project data
		java.util.List<Project> projects = projectService.getAll();
		// Map data to template
		model.addAttribute("projects", projects);
		// Return project home template
		return "projects/main";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		// Create a new project with default constructor
		Project aProject = new Project();
		// Get list of all employees to be added to the project
		java.util.List<Employee> employeesList =  employeeService.getAll();
		// Get user input for new project attributes
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employeesList);
		// Serve new project form page
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, @RequestParam java.util.List<Long> employees, Model model) {
		// Save project to database
		projectService.save(project);
		
		// Following code is no longer needed now that a many to many relation
		// has been created btwn employees and projects
		// Get list of all employees chosen for the project
//		Iterable<Employee> chosenEmployees = empRepo.findAllById(employees);
		
		// Set the project field for each chosen employee and save to db
//		for(Employee employee : chosenEmployees) {
//			employee.setProject(project);
//			empRepo.save(employee);
//		}
		
		// Redirect to prevent duplicate submissions 
		return "redirect:/projects";
	}
}
