package com.kcg.pma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kcg.pma.dao.IEmployeeRepository;
import com.kcg.pma.dao.IProjectRepository;
import com.kcg.pma.entities.Employee;
import com.kcg.pma.entities.Project;

@SpringBootApplication
public class ProjectManagementApplication {
	
	@Autowired
	IEmployeeRepository empRepo;
	
	@Autowired
	IProjectRepository proRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
	
	// Seed the database when the application is started
	// Functionality moved to resources/data.sql
//	@Bean
//	CommandLineRunner runner() {
//		
//		return args -> {
//			Employee emp1 = new Employee("John", "Doe", "john@example.com");
//			Employee emp2 = new Employee("Jane", "Doe", "jane@example.com");
//			Employee emp3 = new Employee("George", "Smith", "george@example.com");
//			
//			Employee emp4 = new Employee("Jerry", "Smith", "jerry@example.com");
//			Employee emp5 = new Employee("Elaine", "Smith", "elaine@example.com");
//			Employee emp6 = new Employee("Tim", "Black", "tim@example.com");
//			
//			Employee emp7 = new Employee("Eric", "Green", "eric@example.com");
//			Employee emp8 = new Employee("Charles", "Brown", "charles@example.com");
//			Employee emp9 = new Employee("Hanna", "White", "hanna@example.com");
//			
//			Project proj1 = new Project("Large Production Deployment", "NOTSTARTED", "This is a project description");
//			Project proj2 = new Project("New Employee Budget", "INPROGRESS", "This is a project description");
//			Project proj3 = new Project("Improve Intranet Security", "COMPLETED", "This is a project description");
//			
			// Set both sides of the project employee relationship
//			proj1.setEmployees(Arrays.asList(emp1, emp2));
//			proj2.setEmployees(Arrays.asList(emp1, emp5));
//			proj3.setEmployees(Arrays.asList(emp7));
//			
//			emp1.setProjects(Arrays.asList(proj1, proj2));
//			emp2.setProjects(Arrays.asList(proj1));
//			emp5.setProjects(Arrays.asList(proj2));
//			emp7.setProjects(Arrays.asList(proj3));
//			
			// Save to database			
//			empRepo.save(emp1);
//			empRepo.save(emp2);
//			empRepo.save(emp3);
//			empRepo.save(emp4);
//			empRepo.save(emp5);
//			empRepo.save(emp6);
//			empRepo.save(emp7);
//			empRepo.save(emp8);
//			empRepo.save(emp9);
//			
//			proRepo.save(proj1);
//			proRepo.save(proj2);
//			proRepo.save(proj3);
//		};
//	}
	
}
