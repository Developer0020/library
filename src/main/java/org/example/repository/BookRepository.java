package org.example.repository;

import org.example.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void addBook(Book book) {
        String sql = "Insert into book(title,author,publishYear,amount,visible) values ('%s','%s',now(),'%s','%s')";
        sql = String.format(sql, book.getTitle(), book.getAuthor(), book.getAmount(),true);
        int n = jdbcTemplate.update(sql);
        if (n > 0) {
            System.out.println("Success !");
        }
    }
    public void updateBook( boolean visible,Integer id) {
        String sql = "update book set visible ='%s' where id='%s'";
        sql=String.format(sql,visible,id);
        int n =jdbcTemplate.update(sql);
        if (n>0){
            System.out.println("Success Deleted !!!");
        }
    }
    public void updateBook(String amount,Integer id) {
        String sql = "update book set amount ='%s' where id='%s'";
        sql=String.format(sql,amount,id);
        int n =jdbcTemplate.update(sql);
        if (n>0){
            System.out.println("Success !!! ");
        }
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
}
