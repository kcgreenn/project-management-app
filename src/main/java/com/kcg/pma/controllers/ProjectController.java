package com.kcg.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kcg.pma.dao.IProjectRepository;
import com.kcg.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	IProjectRepository proRepo;
	
	@GetMapping("")
	public String displayProjectHome(Model model) {
		// Get all project data
		java.util.List<Project> projects = proRepo.findAll();
		// Map data to template
		model.addAttribute("projects", projects);
		// Return project home template
		return "projects/main";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		// Create a new project with default constructor
		Project aProject = new Project();
		// Get user input for new project attributes
		model.addAttribute("project", aProject);
		// Serve new project form page
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		// Save project to database
		proRepo.save(project);
		
		// Redirect to prevent duplicate submissions 
		return "redirect:/projects/new";
	}
}
