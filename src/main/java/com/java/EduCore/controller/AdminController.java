package com.java.EduCore.controller;

import com.java.EduCore.dao.CourseRepository;
import com.java.EduCore.dao.UserRepository;
import com.java.EduCore.dto.CourseResponseDTO;
import com.java.EduCore.dto.InstructorInfoDTO;
import com.java.EduCore.dto.RegisterRequest;
import com.java.EduCore.entity.Course;
import com.java.EduCore.entity.Role;
import com.java.EduCore.entity.User;
import com.java.EduCore.entity.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dashboard")
    public String adminDashboard(){
        return "This is admin dashboard";
    }

    @PostMapping("/courses")
    public ResponseEntity<?> addCourse(@RequestBody Course course){

        if(course.getInstructor() != null){
            Long instructorId = course.getInstructor().getId();
            User instructor = userRepository.findById(instructorId).orElse(null);
            if(instructor == null || instructor.getRole() != Role.ROLE_INSTRUCTOR ){
                return  ResponseEntity.badRequest().body("Invalid instructor ID");
            }
            course.setInstructor(instructor);
        }
        course.setCreatedAt(LocalDateTime.now());
        Course savedCourse = courseRepository.save(course);

        InstructorInfoDTO instructorInfoDTO = new InstructorInfoDTO(
                savedCourse.getInstructor().getId(),
                savedCourse.getInstructor().getEmail(),
                savedCourse.getInstructor().getFirstname() + " " + savedCourse.getInstructor().getLastname()
        );

        CourseResponseDTO responseDTO = new CourseResponseDTO(
                savedCourse.getId(),
                savedCourse.getTitle(),
                savedCourse.getDescription(),
                savedCourse.getCategory(),
                savedCourse.isActive(),
                savedCourse.getPrice(),
                instructorInfoDTO,
                savedCourse.getCreatedAt()
        );

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses(){
        List<Course> courses = courseRepository.findAll();

        List<CourseResponseDTO> courseDTOs = courses.stream().map(course -> {
            InstructorInfoDTO instructorDTO = new InstructorInfoDTO(
                    course.getInstructor().getId(),
                    course.getInstructor().getEmail(),
                    course.getInstructor().getFirstname() + " " + course.getInstructor().getLastname()
            );

            return new CourseResponseDTO(
                    course.getId(),
                    course.getTitle(),
                    course.getDescription(),
                    course.getCategory(),
                    course.isActive(),
                    course.getPrice(),
                    instructorDTO,
                    course.getCreatedAt()
            );
        }).toList();
        return ResponseEntity.ok(courseDTOs);
    }

    @PostMapping("/instructor")
    public ResponseEntity<?> registerInstructor(@RequestBody RegisterRequest request){

        User instructor = new User();
        instructor.setUsername(request.getUsername());
        instructor.setEmail(request.getEmail());
        instructor.setPassword(passwordEncoder.encode(request.getPassword()));
        instructor.setFirstname(request.getFirstname());
        instructor.setLastname(request.getLastname());
        instructor.setPhone(request.getPhone());
        instructor.setAddress(request.getAddress());

        instructor.setRole(Role.ROLE_INSTRUCTOR);
        instructor.setStatus(UserStatus.ACTIVE);
        userRepository.save(instructor);

        return ResponseEntity.ok("Instructor registered successfully");
    }
}
