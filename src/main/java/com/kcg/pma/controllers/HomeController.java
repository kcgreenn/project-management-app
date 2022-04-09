package com.kcg.pma.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kcg.pma.dao.IEmployeeRepository;
import com.kcg.pma.dao.IProjectRepository;
import com.kcg.pma.dto.EmployeeProject;
import com.kcg.pma.dto.StageCount;
import com.kcg.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	IProjectRepository proRepo;
	@Autowired
	IEmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		// Get all projects and employees from database
		java.util.List<Project> projects = proRepo.findAll();
		
		java.util.List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
		
		java.util.List<StageCount> stageCounts = proRepo.getStageCountList();
		// Convert stageCounts to json
		Map<String, Object> map = new HashMap<>();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(stageCounts);
		
		// Send projects data to template
		model.addAttribute("projects", projects);
		
		// Send stageCounts json for stage chart
		model.addAttribute("stageCounts", jsonString);
		
		// Send employee data with project counts
		model.addAttribute("employeesProjectCnt", employeesProjectCnt);
		// Return the home page template
		return "main/home";
	}
}
