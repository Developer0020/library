package org.example.repository;


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
    private JdbcTemplate jdbcTemplate;

    public void addBook(Book book) {
        String sql = "Insert into book(title,auther,publishYear,amount,visible) values ('%s','%s',now(),'%s','%s')";
        sql = String.format(sql, book.getTitle(), book.getAuthor(), book.getAmount(), true);
        int n = jdbcTemplate.update(sql);
        if (n > 0) {
            System.out.println("Success !");
        }
    }
    public void updateBook(Integer id, boolean b) {
//TODO
    }
    public void updateBook(Integer id, String amount) {
//TODO
    }
    public List<Book> bookList() {
        List<Book> bookList = jdbcTemplate.query("select * from book", new BeanPropertyRowMapper<>(Book.class));
        return bookList;
    }
    public Book getBookById(Integer id) {
        String sql = "SELECT * FROM book Where id =" + id;
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class));
        return book;
    }
    public void deleteBook(Integer id, boolean visible) {
//TODO
    }
}
