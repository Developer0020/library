package org.example.repository;

import org.example.database.DbConnection;
import org.example.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private DbConnection dbConnection;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addBook(Book book) {
        String sql = "Insert into book(title,auther,publishYear,amount,visible) values ('%s','%s',now(),'%s','%s')";
        sql = String.format(sql, book.getTitle(), book.getAuthor(), book.getAmount(), true);
        int n = jdbcTemplate.update(sql);
        if (n>0){
            System.out.println("Success !");
        }
//        Connection con = dbConnection.getConnection();
//        try {
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            int b = preparedStatement.executeUpdate();
//            if (b > 0) {
//                System.out.println("Book Success inserted !!! ");
//            }
//            con.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void updateBook(Integer id, boolean b) {

    }

    /* public void create(LessonDTO lessonDTO) {
        String sql = "insert into lesson (name,surname,created_date) values ('%s','%s',now())";
        sql = String.format(sql, lessonDTO.getName(), lessonDTO.getSurname());
        int n = jdbcTemplate.update(sql);
        System.out.println(n);
    }

    public void updateLesson(Integer lessonId, LessonDTO lessonDTO) {
        String sql = "Update lesson set name='%s', surname='%s'  where id = %d";
        sql = String.format(sql, lessonDTO.getName(), lessonDTO.getSurname(), lessonId);
        int n = jdbcTemplate.update(sql);
        System.out.println(n);
    }

    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from lesson", Integer.class);
    }

    public String nameOne() {
        return jdbcTemplate.queryForObject("select name from lesson limit 1", String.class);
    }

    public LessonDTO getLessonById(Integer id) {
        String sql = "SELECT * FROM lesson Where id =" + id;
        LessonDTO dto = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(LessonDTO.class));
        return dto;
    }

    public List<String> getLessonNameList() {
        String sql = "SELECT name FROM lesson";
        List<String> list = jdbcTemplate.queryForList(sql, String.class);
        return list;
    }

    public List<LessonDTO> getLessonList() {
        String sql = "SELECT * FROM lesson";
        List<LessonDTO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LessonDTO.class));
        return list;
    }


    public LessonDTO getLessonByIdTest(Integer id) {
        String sql = "SELECT * FROM lesson Where id =" + id;
        List<LessonDTO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LessonDTO.class));
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    // sId sName bName
    // select s.id as sId, s.name as sName, b.name as bName
    // from student_book sb inner join student as s on s.id = sb.student_id
    // inner join book as b on b.id = sb.book_id

    public List<StudentBook> getStudentBookInfoList() {
        String sql = " select s.id as sId, s.name as sName, b.name as bName " +
                " from student_book sb inner join student as s on s.id = sb.student_id " +
                " inner join book as b on b.id = sb.book_id ";
        List<StudentBook> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentBook.class));
        return list;
    }
}*/
    public List<Book> bookList() {
        List<Book> bookList = jdbcTemplate.query("select * from book", new BeanPropertyRowMapper<>(Book.class));
//        try {
//            Statement statement = con.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from book");
//            while (resultSet.next()) {
//                Book book = new Book();
//                book.setId(resultSet.getInt("id"));
//                book.setTitle(resultSet.getString("title"));
//                book.setAuthor(resultSet.getString("auther"));
//                book.setAmount(resultSet.getString("amount"));
//                book.setPublishYear(resultSet.getDate("publishyear").toLocalDate());
//                book.setVisible(Boolean.parseBoolean(resultSet.getString("visible")));
//                bookList.add(book);
//            }
//            con.close();
//            return bookList;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return bookList;
    }

    public Book getBookById(Integer id) {
        String sql = "SELECT * FROM book Where id =" + id;
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class));
        return book;
    }

    public void deleteBook(Integer id, boolean visible) {

    }
}
////id,title,author, publishYear, amount, visible