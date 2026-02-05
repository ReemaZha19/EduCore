package com.java.EduCore.service;

import com.java.EduCore.dao.CourseRepository;
import com.java.EduCore.dao.EnrollmentRepository;
import com.java.EduCore.dao.UserRepository;
import com.java.EduCore.entity.Course;
import com.java.EduCore.entity.Enrollment;
import com.java.EduCore.entity.EnrollmentStatus;
import com.java.EduCore.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class EnrollmentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Enrollment enroll(String username, Long courseId){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found "));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if(!course.isActive()){
            throw new RuntimeException("Course is not active");
        }

        if(enrollmentRepository.existsByUserAndCourse(user, course)){
            throw new RuntimeException("Already enrolled");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);
        enrollment.setStatus(EnrollmentStatus.ACTIVE);
        enrollment.setEnrolledAt(LocalDateTime.now());

        enrollment.setPaidAmount(course.getPrice());
        enrollment.setTransactionId("TXN-" + System.currentTimeMillis());

        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getEnrollmentByStudent(String username){
        return enrollmentRepository.findAllByUserUsername(username);
    }


}
