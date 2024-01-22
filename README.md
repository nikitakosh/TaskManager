# TaskManager

TaskManager is a web application developed using Spring Boot, designed to manage tasks with basic CRUD functionality. The application allows users to perform Create, Read, Update, and Delete (CRUD) operations on tasks. Additionally, it includes user registration functionality using Spring Security, ensuring that each user has their own account. The application also features email verification for enhanced security.

## Technologies Used

- **Maven**: Project management and build automation tool.
- **Spring Core**: Core functionality of the Spring Framework.
- **Spring Data (Hibernate & Postgresql)**: Data access using Hibernate as the JPA provider and PostgreSQL as the database.
- **Thymeleaf**: Server-side Java template engine for web applications.
- **Spring DATA JPA**: Simplifies the implementation of JPA repositories.
- **Spring Security**: Provides authentication, authorization, and other security features.
- **Lombok**: Reduces boilerplate code in Java.

## Features

- **CRUD Operations**: TaskManager supports basic CRUD operations for managing tasks.
- **User Registration**: Users can register for an account, ensuring a personalized experience.
- **Authentication and Authorization**.
- **Email Verification**: Enhanced security with email verification for user registration.

## Pages
- **Tasks (/tasks)**:
![image](https://github.com/nikitakosh/TaskManager/assets/113053952/40955c65-96b8-40be-809a-ec0ff0fcb3cc)
  
- **Regisatration (/registration)**:
![image](https://github.com/nikitakosh/TaskManager/assets/113053952/d83574a1-1ec2-4c83-a08e-bb510cb676b5)

- **Task (/{id})**:
  ![image](https://github.com/nikitakosh/TaskManager/assets/113053952/0f66e790-9bd6-4f69-b0d5-a2e4dbf77661)

## Email Verification
- When users register for a new account, an email will be sent to the provided email address for verification.
![image](https://github.com/nikitakosh/TaskManager/assets/113053952/119ed257-f5a0-4bad-8036-6f2026805aac)

- To complete the registration process, users must click on the verification link within the email.
![image](https://github.com/nikitakosh/TaskManager/assets/113053952/9e34ef78-b65a-4f8d-b308-1b623b1d7ebf)

- This step enhances the security of the application by ensuring that registered email addresses are valid and owned by the users.

## Prerequisites

- Java Development Kit (JDK)
- Maven
- PostgreSQL (or any other relational database)

## Installation

The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

## Database configuration
Create a Postgresql database with the name TaskManager and add the credentials to /resources/application.properties.
The default ones are :
```
spring.datasource.url=jdbc:postgresql://localhost:5432/TaskManager
spring.datasource.username=admin
spring.datasource.password=
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
```

## Run SMTP Server

[https://github.com/maildev/maildev](https://github.com/maildev/maildev)
```
$ docker run -p 1080:1080 -p 1025:1025 maildev/maildev
```

## Usage
Run the project through the IDE and head out to [http://localhost:8080](http://localhost:8080)

