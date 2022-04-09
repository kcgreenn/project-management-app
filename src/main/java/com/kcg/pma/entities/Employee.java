package com.kcg.pma.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	
	@Id
//	Generate id starting at 1 by default, better for batching operations
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	Generate id based on values already in db
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long employeeId;
	
	private String firstName;
	private String lastName;
	
	private String email;
	
	// Create a many to one relationship between employees and projects. projectId as foreign key. 
	// Cascade all but "REMOVE" and only fetch the employees of the current project.
	@ManyToMany(
			cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST}, 
			fetch = FetchType.LAZY
	)
	@JoinTable(
			name="project_employee", 
			joinColumns=@JoinColumn(name="employeeId"), 
			inverseJoinColumns=@JoinColumn(name="projectId")
		)
	private java.util.List<Project> projects;

	public java.util.List<Project> getProjects() {
		return projects;
	}

	public void setProjects(java.util.List<Project> projects) {
		this.projects = projects;
	}

	public Employee() {
		
	}

	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
