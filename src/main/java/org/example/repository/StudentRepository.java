package org.example.repository;

import org.example.database.DbConnection;
import org.example.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private DbConnection dbConnection;

    public void addStudent(Student student) {
        Connection con = dbConnection.getConnection();
        String sql = "insert into student (name,surname,phone,createdDate,visible) values ('%s','%s','%s',now(),'%s'";
        sql = String.format(sql, student.getName(), student.getSurname(), student.getPhone(), true);

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            int b = preparedStatement.executeUpdate();
            if (b > 0) {
                System.out.println("Student Success inserted !!!");
            } else {
                System.err.println("Err");
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> studentList() {
        List<Student> studentList = new LinkedList<>();
        Connection con = dbConnection.getConnection();
        String sql = "Select * from student ";
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surName"));
                student.setCreatedDate(resultSet.getDate("createdDate").toLocalDate());
                student.setPhone(resultSet.getString("phone"));
                student.setVisible(Boolean.parseBoolean(resultSet.getString("visible")));
                studentList.add(student);
            }
            con.close();
            return studentList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student getStudentById(Integer id, String phone) {
        Connection con = dbConnection.getConnection();
        Student student = new Student();
        String sql = String.format("select * from student where id='%s' and phone ='%s'", id, phone);
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone"));
                student.setCreatedDate(resultSet.getDate("createdDate").toLocalDate());
                student.setVisible(resultSet.next());
            }
            con.close();
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteStudent() {

    }
}
