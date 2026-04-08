# Hospital Management System (Spring Boot + JWT)

> **Note:**  
> The complete source code for this project is available in the `dev` branch.  
> The `main` branch contains only project overview and documentation.

---

## Project Overview

This is a simple and practical **Hospital Management System backend application** built using **Spring Boot** with **JWT Authentication**.

The project is designed for learning and demonstration purposes, focusing on:

* Spring Boot project structure
* JWT-based authentication
* Securing REST APIs
* CRUD operations
* Clean backend development practices

> Note: This is a mini-project intended for students, not a full-scale hospital system.

---

## Project Goal

The main objective of this project is to:

* Allow users to **register and login**
* Generate **JWT token after login**
* Secure APIs using JWT
* Perform **CRUD operations on patient records**

---

## Modules

### Auth Module

Handles:

* User Registration
* User Login
* JWT Token Generation
* JWT Validation
* API Security

### Patient Module

Handles:

* Add Patient
* View All Patients
* View Patient by ID
* Update Patient
* Delete Patient

---

## Technologies Used

* Java
* Spring Boot
* Spring Web
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA
* MySQL
* Lombok
* Maven
* Postman (for testing)

---

## Project Structure
```

hospital-management-system/
├── config/
├── controller/
├── dto/
├── entity/
├── repository/
├── service/
└── HospitalManagementApplication.java
```

---

## Authentication Flow

1. User registers with name, email, and password
2. Password is encrypted and stored
3. User logs in with credentials
4. JWT token is generated
5. Token is used to access secured APIs

---

## API Endpoints

### Auth APIs

#### Register

POST /api/auth/register

#### Login

POST /api/auth/login

---

### Patient APIs (Secured)

#### Add Patient

POST /api/patients

#### Get All Patients

GET /api/patients

#### Get Patient by ID

GET /api/patients/{id}

#### Update Patient

PUT /api/patients/{id}

#### Delete Patient

DELETE /api/patients/{id}

---

## Authorization Header

To access secured APIs, include JWT token:

Authorization: Bearer <your_token>

---

## Database Design

### Users Table

* id
* name
* email
* password
* role

### Patients Table

* id
* name
* age
* gender
* disease
* address
* phone_number

---

## Configuration (application.properties)

spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080

jwt.secret=your_secret_key
jwt.expiration=86400000

---

## How to Run

1. Clone the repository
2. Open in IntelliJ / Eclipse
3. Configure MySQL database
4. Run the application
5. Use Postman to test APIs

---

## Features

* JWT Authentication
* Secure REST APIs
* CRUD Operations
* Clean Architecture
* Easy to understand

---

## Limitations

* No frontend
* No doctor module
* No appointment system
* No advanced role-based access

---

## Future Enhancements

* Doctor module
* Appointment scheduling
* Role-based access control
* Frontend (React/Angular)
* Pagination & search
* Swagger documentation

---

## Conclusion

This project demonstrates how to build a **secure backend application** using Spring Boot and JWT.
It is simple, practical, and ideal for learning, viva, and project submission.