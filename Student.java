
package com.example.studentcourse.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Student {

    private int studentId;

    @NotBlank(message = "Student name cannot be empty")
    private String studentName;

    @NotBlank(message = "Course name cannot be empty")
    private String courseName;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Enter valid email")
    private String email;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }


    public String getCourseName() {
        return courseName;
    }

  
    public String getEmail() {
        return email;
    }

    

    public int getAge() {
        return age;
    }

    
}
 