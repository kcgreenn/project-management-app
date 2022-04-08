package com.kcg.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.kcg.pma.entities.Project;

public interface IProjectRepository extends CrudRepository<Project, Long>{
	
}
