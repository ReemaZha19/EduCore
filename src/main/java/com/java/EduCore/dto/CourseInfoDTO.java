package com.java.EduCore.dto;

public class CourseInfoDTO {

    private Long id;
    private String title;
    private String category;
    private double price;
    private boolean active;
    private InstructorInfoDTO instructor;

    public CourseInfoDTO() {
    }

    public CourseInfoDTO(Long id, String title, String category, double price, boolean active, InstructorInfoDTO instructor) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.active = active;
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public InstructorInfoDTO getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorInfoDTO instructor) {
        this.instructor = instructor;
    }
}
