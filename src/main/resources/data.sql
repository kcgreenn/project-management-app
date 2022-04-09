-- Insert Employees
insert into EMPLOYEE (employee_id, first_name, last_name, email) values (1, 'John', 'Wharton', 'example@example.com');
insert into employee (employee_id, first_name, last_name, email) values (2, 'Mike', 'Lanister', 'example@example.com');
insert into employee (employee_id, first_name, last_name, email) values (3, 'Steve', 'Reeves', 'example@example.com');
insert into employee (employee_id, first_name, last_name, email) values (4, 'Ronald', 'Connor', 'example@example.com');
insert into employee (employee_id, first_name, last_name, email) values (5, 'Jim', 'Salvator', 'example@example.com');
insert into employee (employee_id, first_name, last_name, email) values (6, 'Peter', 'Henley', 'example@example.com');
insert into employee (employee_id, first_name, last_name, email) values (7, 'Richard', 'Carson', 'example@example.com');
insert into employee (employee_id, first_name, last_name, email) values (8, 'Honor', 'Miles', 'example@example.com');
insert into employee (employee_id, first_name, last_name, email) values (9, 'Tony', 'Rogers', 'example@example.com');

-- Insert Projects
insert into project (project_id, name, stage, description) values (1000, 'Project 1', 'NOTSTARTED', 'Description of the project.');
insert into project (project_id, name, stage, description) values (1001, 'Project 2', 'COMPLETED', 'Description of the project.');
insert into project (project_id, name, stage, description) values (1002, 'Project 3', 'INPROGRESS', 'Description of the project.');
insert into project (project_id, name, stage, description) values (1003, 'Project 4', 'INPROGRESS', 'Description of the project.');

-- Insert Project_Employee_Relation
insert into project_employee (employee_id, project_id) values (1, 1000);
insert into project_employee (employee_id, project_id) values (1, 1001);
insert into project_employee (employee_id, project_id) values (1, 1002);
insert into project_employee (employee_id, project_id) values (3, 1000);
insert into project_employee (employee_id, project_id) values (6, 1002);
insert into project_employee (employee_id, project_id) values (6, 1003);
