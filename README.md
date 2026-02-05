EduCore Backend

EduCore is a backend Learning Management System (LMS) developed using Spring Boot.
The project is implemented in phases to demonstrate secure authentication, database-driven design, and role-based LMS workflows.

Implemented Features:
  Authentication & Security
  JWT-based stateless authentication
  Role-based authorization (ADMIN, INSTRUCTOR, STUDENT)
  Secure password hashing using BCrypt
  Custom JWT authentication filter
  Spring Security filter chain configuration

Database & Persistence:
  MySQL integration using Spring Data JPA and Hibernate
  Persistent storage for users, courses, and enrollments
  Proper entity relationships and constraints
  DTO-based API responses to avoid exposing entities

LMS(Learning Management System) Core Functionality:
  User management with role separation
  Course creation and management
  Instructor–course association
  Student course enrollment with duplicate prevention
  Enrollment tracking (status, progress, payment, certificate flag)
  Role-restricted API access for admin, instructor, and student

Domain Model Overview:
  User:
    Represents admin, instructor, and student roles
    Stores authentication credentials and profile information
    Linked to enrollments

  Course:
    Created and managed by instructors
    Includes title, description, category, duration, price, and active status
    Linked to enrollments

  Enrollment:
    Connects students to courses
    Enforces unique enrollment per student per course
    Tracks enrollment lifecycle and metadata

Technology Stack:
  Java
  Spring Boot
  Spring Security
  Spring Data JPA
  Hibernate
  JWT (jjwt)
  BCrypt
  MySQL

Project Structure:
  Layered architecture (Controller, Service, Repository)
  DTO-based response handling
  Centralized security configuration
  ransaction-managed service layer

Project Status:
  Phase 1: Authentication and authorization completed
  Phase 2: Database integration and LMS core features completed
  Phase 3: Frontend integration planned
