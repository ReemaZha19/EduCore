package com.java.EduCore.dao;

import com.java.EduCore.entity.Course;
import com.java.EduCore.entity.Enrollment;
import com.java.EduCore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    boolean existsByUserAndCourse(User user, Course course);
    List<Enrollment> findAllByUserUsername(String username);
}
