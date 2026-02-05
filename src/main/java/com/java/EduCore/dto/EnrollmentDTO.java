package com.java.EduCore.dto;

import java.time.LocalDateTime;

public class EnrollmentDTO {

    private Long id;
    private StudentInfoDTO student;
    private CourseInfoDTO course;
    private String status;
    private LocalDateTime enrolledAt;
    private LocalDateTime completedAt;
    private double progress;
    private double score;
    private String feedback;
    private String transactionId;
    private double paidAmount;
    private boolean certificateIssued;

    public EnrollmentDTO() {
    }

    public EnrollmentDTO(Long id, CourseInfoDTO course, StudentInfoDTO student, String status, LocalDateTime enrolledAt, LocalDateTime completedAt, double progress, double score, String feedback, String transactionId, double paidAmount, boolean certificateIssued) {
        this.id = id;
        this.course = course;
        this.student = student;
        this.status = status;
        this.enrolledAt = enrolledAt;
        this.completedAt = completedAt;
        this.progress = progress;
        this.score = score;
        this.feedback = feedback;
        this.transactionId = transactionId;
        this.paidAmount = paidAmount;
        this.certificateIssued = certificateIssued;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentInfoDTO getStudent() {
        return student;
    }

    public void setStudent(StudentInfoDTO student) {
        this.student = student;
    }

    public CourseInfoDTO getCourse() {
        return course;
    }

    public void setCourse(CourseInfoDTO course) {
        this.course = course;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(LocalDateTime enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public boolean isCertificateIssued() {
        return certificateIssued;
    }

    public void setCertificateIssued(boolean certificateIssued) {
        this.certificateIssued = certificateIssued;
    }
}
