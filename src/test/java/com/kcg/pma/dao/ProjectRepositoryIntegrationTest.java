package com.kcg.pma.dao;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kcg.pma.ProjectManagementApplication;
import com.kcg.pma.dao.IProjectRepository;
import com.kcg.pma.entities.Project;

import junit.runner.Version;

@SpringBootTest
//@ContextConfiguration(classes=ProjectManagementApplication.class)	// Loads spring context from starting point of application/ only needed if file name doesn't match project
@ExtendWith(SpringExtension.class)
@SqlGroup({
	@Sql(
		executionPhase=ExecutionPhase.BEFORE_TEST_METHOD, 
		scripts= {"classpath:schema.sql", "classpath:data.sql"}
	),
	@Sql(
		executionPhase=ExecutionPhase.AFTER_TEST_METHOD,
		scripts= "classpath:drop.sql"
	)
}
)	// Run sql files before/after tests run
public class ProjectRepositoryIntegrationTest {

	@Autowired
	IProjectRepository proRepo;
	
	@Test
	public void ifNewProjectSaved_thenSuccess() {
		Project newProject = new Project("New Test Project", "COMPLETE", "Test description.");
		proRepo.save(newProject);
		
		System.out.println("JUnit version is: " + Version.id());
		
		// after code runs, there should be 5 projects in db
		assertEquals(9, proRepo.findAll().size());
	}
}
