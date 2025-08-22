🔐 Spring Boot JWT Authentication System
📖 Overview
This is a secure JWT-based authentication system built with Spring Boot. The project provides complete user registration, login, and password management functionality with MySQL database integration and email services for password recovery.

🎯 Why This Project?
I created this project to:

Learn and implement JWT authentication properly

Understand Spring Security in depth

Practice secure password handling and encryption

Implement production-ready authentication flows

Learn database integration with Spring Data JPA

Understand email services for user management

🛠️ Technology Stack
Backend Framework
Spring Boot 3.5.4 - Main application framework

Spring Security - Authentication and authorization

Spring Data JPA - Database operations

Spring Mail - Email services

Database
MySQL - Primary database for user data

Hibernate - ORM implementation

Authentication
JWT (JSON Web Tokens) - Stateless authentication

BCrypt Password Encoding - Secure password hashing

Email Service
Gmail SMTP - Password reset emails

JavaMailSender - Email integration

Build Tool
Maven - Dependency management and build automation

Security Features
✅ JWT token-based authentication

✅ Password encryption with BCrypt

✅ Secure password reset flow

✅ CORS configuration

✅ Environment variable protection

✅ SQL injection prevention

📋 Features
User Management
User registration with email verification

Secure login with JWT tokens

Password reset via email

Token-based authentication

Security
JWT token generation and validation

Password hashing with BCrypt

Secure HTTP headers

CORS configuration

SQL injection prevention

Email Services
Password reset emails

Account verification (can be extended)

Email template system

🚀 API Endpoints
Authentication
POST /api/auth/register - User registration

POST /api/auth/login - User login (returns JWT)

Password Management
POST /api/password/forgot - Initiate password reset

POST /api/password/reset - Reset password with token

GET /api/password/validate-token - Validate reset token

Test Endpoints
GET /api/test/public - Public access endpoint

GET /api/test/private - JWT-protected endpoint

📁 Project Structure
text
src/
├── main/
│   ├── java/co/Nitish/JWT/
│   │   ├── config/          # Security and application config
│   │   ├── controller/      # REST API controllers
│   │   ├── entity/          # Database entities
│   │   ├── repository/      # Data access layer
│   │   ├── security/        # JWT and security components
│   │   ├── service/         # Business logic layer
│   │   └── dto/            # Data transfer objects
│   └── resources/
│       ├── application.properties     # Configuration
│       └── static/           # Frontend assets
└── test/                     # Test cases
