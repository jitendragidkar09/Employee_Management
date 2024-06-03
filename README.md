# Employee_Management
This repository contains a project for managing employees and department data efficiently using REST APIs, PostgreSQL, and JWT for authentication.
<pre>
<h2>Overview</h2>
This project is an Employee Management System built using:

- REST API: For building the API
- JWT (JSON Web Tokens): For token-based authentication and authorization
- PostgreSQL: As the database management system
- Roles: Implemented user and admin roles with different permissions

<h2>Features</h2>
- Employee Management: Create, read, update, and delete employee records.
- Department Management: Manage departments, ensuring that each employee is associated with a valid department. 
- JWT Authentication: Secure API endpoints with JSON Web Tokens for authentication and authorization.
- Foreign Key Constraints: Maintain data integrity with a foreign key relationship between the employee and department tables.

<h2>Technologies Used</h2>
- Springboot ToolSuite(STS): To develop RESTful API
- Backend: Java with Spring Boot
- Database: PostgreSQL
- Authentication: JWT (JSON Web Tokens)
- Authorization: Role-based access control
- API: RESTful API

<h2>Getting Started</h2>
- Clone the repository
- Run the application using Spring Boot
- Use Postman to test the API endpoints

 <h2>API Endpoints</h2>
- /employees: Get all employees (Accessible by Admin only)
- /employees/{employeeId}: Get employee by ID (Accessible by User only)
- /add/employees: Create a new employee (Accessible by Admin only)
- /employees/{employeeId}[For method @PutMapping]: Update an existing employee (Accessible by User and Admin)
- /employees/{employeeId}[For method @DeleteMapping]: Delete an employee (Accessible by Admin only)
- /departments: Get all departments (Accessible by Admin only)
- /departments/{departmentId}: Get department by ID (Accessible by User and Admin)
- /authenticate: To authenticate the user available in database or to generate token

<h2>Assumptions</h2>
- Database and Tables are created in pgAdmin using postgressql
- Department Id is foriegn key in Employee Table
- Make sure department table is populated with the department you refer for an employee

  <h2>Note:</h2> Before testing the API, ensure that your connection details in application properties file are correct.
</pre>
