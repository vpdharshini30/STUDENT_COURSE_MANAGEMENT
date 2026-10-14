
package com.example.studentcourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentcourse.model.Student;
import com.example.studentcourse.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 1. Register Student
    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(
            @Valid @RequestBody Student student) {

        String result = studentService.registerStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(result);
    }

    // 2. View All Students
    @GetMapping
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }

    // 3. Find Student By ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(
            @PathVariable int id) {

        Student student = studentService.getStudentById(id);

        if (student != null) {
            return ResponseEntity.ok(student);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Student ID Not Found");
    }

    // 4. Delete Student Registration
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable int id) {

        String result = studentService.deleteStudent(id);

        if (result.equals("Student ID Not Found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(result);
        }

        return ResponseEntity.ok(result);
    }
}
