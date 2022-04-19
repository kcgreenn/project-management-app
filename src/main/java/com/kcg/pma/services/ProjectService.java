package com.kcg.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kcg.pma.dao.IProjectRepository;
import com.kcg.pma.dto.StageCount;
import com.kcg.pma.entities.Project;

@Service
public class ProjectService {
	@Autowired
	IProjectRepository projectRepository;
	
	public Project save(Project project) {
		return projectRepository.save(project);
	}
	
	public List<Project>getAll() {
		return projectRepository.findAll();
	}
	
	public List<StageCount> getProjectStatus(){
		return projectRepository.getStageCountList();
	}
}
