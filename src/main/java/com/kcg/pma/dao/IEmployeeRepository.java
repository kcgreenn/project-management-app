package com.kcg.pma.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kcg.pma.dto.EmployeeProject;
import com.kcg.pma.entities.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Long>{
	@Override
	public java.util.List<Employee> findAll();
	
	@Query(nativeQuery = true, value="SELECT first_name as \"firstName\", last_name as \"lastName\", COUNT(project_employee.employee_id) as \"projectCount\"\n"
			+ "FROM employee left join project_employee ON project_employee.employee_id = employee.employee_id\n"
			+ "GROUP BY employee.first_name, employee.last_name \n"
			+ "ORDER BY 3 DESC;")
	public java.util.List<EmployeeProject> employeeProjects();
}
