package com.java.EduCore.dto;

import java.time.LocalDateTime;

public class CourseResponseDTO {

    private Long id;
    private String title;
    private String description;
    private String category;
    private double price;
    private boolean active;

    private InstructorInfoDTO instructor;

    private LocalDateTime createdAt;

    public CourseResponseDTO() {
    }

    public CourseResponseDTO(Long id, String title, String description, String category, boolean active, double price, InstructorInfoDTO instructor, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.active = active;
        this.price = price;
        this.instructor = instructor;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setInstructor(InstructorInfoDTO instructor) {
        this.instructor = instructor;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public InstructorInfoDTO getInstructor() {
        return instructor;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
