# Authentication API with Spring Security
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">
<img src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white" alt="">
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="">
<img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white" alt="">
<p>
This is an API developed using Java 21, Spring (v3.2.2) and Spring Security, Flyway Migrations, MySQL and JWT for authentication control.
</p>

## Table of Contents
1. [Requirements](#requirements)
2. [Usage](#usage)
3. [Authentication](#authentication)

## Requirements
* Install [MySQL](https://www.mysql.com/downloads/)
* Clone the project
<pre>
<code>
git clone https://github.com/lucasfeitozas/spring-security-jwt.git
</code>
</pre>

## Usage
First, you need to install MySQL database and Java JDK (version 21). After this, clone this project and execute
```
cd spring-security-jwt
mvn clean install
java -jar target/authentication-0.0.1-SNAPSHOT.jar
```

## API Endpoints

``` 
POST /auth/login - Login into the App

POST /auth/register - Register a new user

GET /movies - Retrieve a list of movies. (all authenticated users)

POST /movies - Register a new movie (ADMIN access required).
```

##  Authentication
This application uses Spring Security for authentication control. The following roles are available:
* **USER**: Standard user role for logged-in users.
* **ADMIN**: Admin role for managing movies (registering new movies).

To access protected endpoints as an **ADMIN** user, provide the appropriate authentication credentials in the request header.
