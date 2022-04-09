package com.kcg.pma.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kcg.pma.dto.StageCount;
import com.kcg.pma.entities.Project;

public interface IProjectRepository extends CrudRepository<Project, Long>{
	@Override
	public java.util.List<Project> findAll();
	
	@Query(nativeQuery = true, value="SELECT project.stage as label, COUNT(project.stage) as value \n"
			+ "FROM project \n"
			+ "GROUP BY project.stage;")
	public java.util.List<StageCount> getStageCountList();
}
