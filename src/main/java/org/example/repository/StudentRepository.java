package org.example.repository;


import org.example.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addStudent(Student student) {
        String sql = "insert into student (name,surname,phone,createddate,visible) values ('%s','%s','%s',now(),'%s')";
        sql = String.format(sql, student.getName(), student.getSurname(), student.getPhone(), true);
        int b = jdbcTemplate.update(sql);
        if (b > 0) {
            System.out.println("Success !");
        }
    }

    public List<Student> studentList() {
        String sql = "Select * from student ";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        return studentList;
    }

    public Student getStudentByPhone(String phone) {
        String sql = "select * from student where  phone ='%s'";
        sql = String.format(sql, phone);
        return   jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class));

    }

    public void deleteStudent(Integer id, boolean visible) {
        String sql = String.format("update student set visible ='%s' where id ='%s'", visible, id);
        int rowsAffected = jdbcTemplate.update(sql);
        if (rowsAffected > 0) {
            System.out.println("Success !!!");
        }
    }
}
