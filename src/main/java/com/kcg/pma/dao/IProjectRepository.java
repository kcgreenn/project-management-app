package com.kcg.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.kcg.pma.entities.Project;

import antlr.collections.List;

public interface IProjectRepository extends CrudRepository<Project, Long>{
	@Override
	public java.util.List<Project> findAll();
}
