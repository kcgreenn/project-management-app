-- INSERT EMPLOYEES
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'John', 'Warton', 'warton@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Mike', 'Lanister', 'lanister@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Steve', 'Reeves', 'reeves@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Ronald', 'Connor', 'connor@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Jim', 'Salvator', 'salvator@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Peter', 'Henley', 'henley@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Richard', 'Carson', 'carson@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Honor', 'Miles', 'miles@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Tony', 'Roggers', 'roggers@gmail.com');

-- INSERT PROJECTS
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Large Production Deployment', 'NOTSTARTED', 'This is required.');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'New Employee Budget', 'COMPLETED', 'This is required.');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Office Reconstruction', 'INPROGRESS', 'This is required.');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Improve Intranet Security', 'INPROGRESS', 'This is required.');

-- INSERT PROJECT_EMPLOYEE_RELATION
insert into project_employee (employee_id, project_id)
	select employee.employee_id, project.project_id from employee, project where employee.last_name='Warton' AND project.name='Large 		Production Deployment';
insert into project_employee (employee_id, project_id) 
	select employee.employee_id, project.project_id from employee, project where employee.last_name='Warton' AND project.name='New Employee 	Budget';
insert into project_employee (employee_id, project_id) 
	select employee.employee_id, project.project_id from employee, project where employee.last_name='Warton' AND project.name='Office 		Reconstruction';
insert into project_employee (employee_id, project_id) 
	select employee.employee_id, project.project_id from employee, project where employee.last_name='Reeves' AND project.name='Large 		Production Deployment';
insert into project_employee (employee_id, project_id) 
	select employee.employee_id, project.project_id from employee, project where employee.last_name='Warton' AND project.name='New Employee 	Budget';
insert into project_employee (employee_id, project_id) 
	select employee.employee_id, project.project_id from employee, project where employee.last_name='Warton' AND project.name='Improve 		Intranet Security';
insert into project_employee (employee_id, project_id) 
	select employee.employee_id, project.project_id from employee, project where employee.last_name='Henley' AND project.name='Office 		Reconstruction';
insert into project_employee (employee_id, project_id) 
	select employee.employee_id, project.project_id from employee, project where employee.last_name='Henley' AND project.name='Improve 		Intranet Security';
