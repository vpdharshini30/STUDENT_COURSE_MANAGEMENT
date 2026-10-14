
package com.example.studentcourse.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.studentcourse.model.Student;


@Repository
public class StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 1. Register Student
    public int registerStudent(Student student) {

        String sql = "INSERT INTO students "
                + "(student_name, course_name, email, age) "
                + "VALUES (?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
                student.getStudentName(),
                student.getCourseName(),
                student.getEmail(),
                student.getAge());
    }

    // 2. View All Students
    public List<Student> getAllStudents() {

        String sql = "SELECT * FROM students";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            Student student = new Student();

            student.setStudentId(rs.getInt("student_id"));
            student.setStudentName(rs.getString("student_name"));
            student.setCourseName(rs.getString("course_name"));
            student.setEmail(rs.getString("email"));
            student.setAge(rs.getInt("age"));

            return student;
        });
    }

    // 3. Find Student By ID
    public Student getStudentById(int id) {

        String sql = "SELECT * FROM students "
                + "WHERE student_id = ?";

        List<Student> students = jdbcTemplate.query(
                sql,(rs, rowNum) -> {

                    Student student = new Student();
                    student.setStudentId(rs.getInt("student_id"));
                    student.setStudentName(rs.getString("student_name"));
                    student.setCourseName(rs.getString("course_name"));
                    student.setEmail(rs.getString("email"));
                    student.setAge(rs.getInt("age"));
                    return student;
                },
                id);

        return students.isEmpty() ? null : students.get(0);
    }

    // 4. Delete Student Registration
    public int deleteStudent(int id) {

        String sql = "DELETE FROM students "
                + "WHERE student_id = ?";

        return jdbcTemplate.update(sql, id);
    }
}
