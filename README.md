# EduCore – Backend

EduCore is a backend service built using Spring Boot and Spring Security.
Phase 1 focuses on implementing secure authentication and authorization
using JWT.

## Features (Phase 1)
- JWT-based authentication (stateless)
- Role-based authorization (ADMIN / USER)
- BCrypt password encryption
- Custom JWT authentication filter
- Spring Security filter chain configuration
- In-memory user store (for learning & testing)

## Tech Stack
- Java
- Spring Boot
- Spring Security
- JWT (jjwt)
- BCrypt

## API Endpoints
POST /auth/login  
POST /auth/register  

GET /admin/dashboard (ROLE_ADMIN)  
GET /user/profile (ROLE_USER)

## Authentication Flow
1. User logs in with username & password
2. Server validates credentials
3. JWT is generated with role information
4. Client sends JWT in Authorization header
5. JwtAuthenticationFilter validates token on every request

## Project Status
Phase 1 completed.
Phase 2 will include database integration and advanced security features.
