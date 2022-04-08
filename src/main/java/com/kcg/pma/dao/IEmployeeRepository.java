package com.kcg.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.kcg.pma.entities.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Long>{
	@Override
	public java.util.List<Employee> findAll();
}
