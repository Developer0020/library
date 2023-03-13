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
//
//        try {
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            int b = preparedStatement.executeUpdate();
//            if (b > 0) {
//                System.out.println("Student Success inserted !!!");
//            } else {
//                System.err.println("Err");
//            }
//            con.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public List<Student> studentList() {
        String sql = "Select * from student ";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        return studentList;
//        try {
//            Statement statement = con.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                Student student = new Student();
//                student.setId(resultSet.getInt("id"));
//                student.setName(resultSet.getString("name"));
//                student.setSurname(resultSet.getString("surName"));
//                student.setCreatedDate(resultSet.getDate("createdDate").toLocalDate());
//                student.setPhone(resultSet.getString("phone"));
//                student.setVisible(Boolean.parseBoolean(resultSet.getString("visible")));
//                studentList.add(student);
//            }
//            con.close();
//            return studentList;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public Student getStudentById(Integer id, String phone) {
        String sql = String.format("select * from student where id='%s' and phone ='%s'", id, phone);
        Student student = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class));
        return student;
//        try {
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                student.setId(resultSet.getInt("id"));
//                student.setName(resultSet.getString("name"));
//                student.setSurname(resultSet.getString("surname"));
//                student.setPhone(resultSet.getString("phone"));
//                student.setCreatedDate(resultSet.getDate("createdDate").toLocalDate());
//                student.setVisible(resultSet.next());
//            }
//            con.close();
//            return student;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void deleteStudent(Integer id, boolean visible) {
        String sql = String.format("update student set visible ='%s' where id ='%s'", visible, id);
        int rowsAffected = jdbcTemplate.update(sql);
        if (rowsAffected > 0) {
            System.out.println("Success !!!");
        }
    }
//        Connection con = dbConnection.getConnection();
//        try {
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            int b = preparedStatement.executeUpdate();
//            if (b > 0) {
//                System.out.println("Student Success Deleted !!! ");
//            }
//            con.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
