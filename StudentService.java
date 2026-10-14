
package com.example.studentcourse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentcourse.dao.StudentDAO;
import com.example.studentcourse.model.Student;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    // 1. Register Student
    public String registerStudent(Student student) {

        int result = studentDAO.registerStudent(student);

        if (result > 0) {
            return "Student Registered Successfully";
        } else {
            return "Student Registration Failed";
        }
    }

    // 2. View All Students
    public List<Student> getAllStudents() {

        return studentDAO.getAllStudents();
    }

    // 3. Find Student By ID
    public Student getStudentById(int id) {

        return studentDAO.getStudentById(id);
    }

    // 4. Delete Student Registration
    public String deleteStudent(int id) {

        int result = studentDAO.deleteStudent(id);

        if (result > 0) {
            return "Student Registration Deleted Successfully";
        } else {
            return "Student ID Not Found";
        }
    }
}
