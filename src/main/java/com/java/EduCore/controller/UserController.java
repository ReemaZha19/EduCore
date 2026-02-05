package com.java.EduCore.controller;

import com.java.EduCore.dto.CourseInfoDTO;
import com.java.EduCore.dto.EnrollmentDTO;
import com.java.EduCore.dto.InstructorInfoDTO;
import com.java.EduCore.dto.StudentInfoDTO;
import com.java.EduCore.entity.Enrollment;
import com.java.EduCore.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/profile")
    public String userProfile(){
        return "This is the user profile";
    }

    @PostMapping("/enroll/{courseId}")
    public ResponseEntity<EnrollmentDTO> enroll(
            @PathVariable Long courseId,
            Principal principal
    ){
        Enrollment enrollment = enrollmentService.enroll(principal.getName(), courseId);

        StudentInfoDTO studentDTO = new StudentInfoDTO(
                enrollment.getUser().getId(),
                enrollment.getUser().getUsername(),
                enrollment.getUser().getEmail(),
                enrollment.getUser().getFirstname() + " " + enrollment.getUser().getLastname()
        );

        InstructorInfoDTO instructorDTO = new InstructorInfoDTO(
                enrollment.getCourse().getInstructor().getId(),
                enrollment.getCourse().getInstructor().getEmail(),
                enrollment.getCourse().getInstructor().getFirstname() + " " + enrollment.getCourse().getInstructor().getLastname()
        );

        CourseInfoDTO courseDTO = new CourseInfoDTO(
                enrollment.getCourse().getId(),
                enrollment.getCourse().getTitle(),
                enrollment.getCourse().getCategory(),
                enrollment.getCourse().getPrice(),
                enrollment.getCourse().isActive(),
                instructorDTO
        );

        EnrollmentDTO enrollmentDTO = new EnrollmentDTO(
                enrollment.getId(),
                courseDTO,
                studentDTO,
                enrollment.getStatus().name(),
                enrollment.getEnrolledAt(),
                enrollment.getCompletedAt(),
                enrollment.getProgress(),
                enrollment.getScore(),
                enrollment.getFeedback(),
                enrollment.getTransactionId(),
                enrollment.getPaidAmount(),
                enrollment.isCertificateIssued()
        );

        return ResponseEntity.ok(enrollmentDTO);
    }

    @GetMapping("/enrollments")
    public ResponseEntity<List<EnrollmentDTO>> getMyEnrollments(Principal principal){

        List<Enrollment> enrollments =
                enrollmentService.getEnrollmentByStudent(principal.getName());

        List<EnrollmentDTO> dtos = enrollments.stream().map(enrollment -> {

            StudentInfoDTO studentDTO = new StudentInfoDTO(
                    enrollment.getUser().getId(),
                    enrollment.getUser().getUsername(),
                    enrollment.getUser().getEmail(),
                    enrollment.getUser().getFirstname() + " " + enrollment.getUser().getLastname()
            );

            InstructorInfoDTO instructorDTO = new InstructorInfoDTO(
                    enrollment.getCourse().getInstructor().getId(),
                    enrollment.getCourse().getInstructor().getEmail(),
                    enrollment.getCourse().getInstructor().getFirstname() + " " + enrollment.getCourse().getInstructor().getLastname()
            );

            CourseInfoDTO courseDTO = new CourseInfoDTO(
                    enrollment.getCourse().getId(),
                    enrollment.getCourse().getTitle(),
                    enrollment.getCourse().getCategory(),
                    enrollment.getCourse().getPrice(),
                    enrollment.getCourse().isActive(),
                    instructorDTO
            );

            return new EnrollmentDTO(
                    enrollment.getId(),
                    courseDTO,
                    studentDTO,
                    enrollment.getStatus().name(),
                    enrollment.getEnrolledAt(),
                    enrollment.getCompletedAt(),
                    enrollment.getProgress(),
                    enrollment.getScore(),
                    enrollment.getFeedback(),
                    enrollment.getTransactionId(),
                    enrollment.getPaidAmount(),
                    enrollment.isCertificateIssued()
            );
        }).collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }
}

