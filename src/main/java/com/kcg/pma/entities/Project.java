package com.kcg.pma.entities;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "project_generator")
	@SequenceGenerator(name = "project_generator", sequenceName = "project_seq", allocationSize = 1)
	private long projectId;
	
	public java.util.List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(java.util.List<Employee> employees) {
		this.employees = employees;
	}
	private String name;
	
	private String stage;	// Not Started / In Progress / Completed
	
	private String description;
	
	@ManyToMany(
			cascade= {
					CascadeType.DETACH, 
					CascadeType.MERGE, 
					CascadeType.REFRESH,
					CascadeType.PERSIST
				}, 
			fetch = FetchType.LAZY
	)
	@JoinTable(
		name="project_employee", 
		joinColumns=@JoinColumn(name="projectId"), 
		inverseJoinColumns=@JoinColumn(name="employeeId")
	)
	private java.util.List<Employee> employees;
	
	public Project() {
		
	}
	
	// Database will create id automatically
	public Project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	// convenience method
	public void addEmployee(Employee employee) {
		if(employees==null) {
			employees = new ArrayList<>();
		}
		employees.add(employee);
	}
}
