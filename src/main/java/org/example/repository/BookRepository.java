package org.example.repository;

import org.example.database.DbConnection;
import org.example.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private DbConnection dbConnection;

    public void addBook(Book book) {
        String sql = "Insert into book(title,author,publishYear,amount,visible) values ('%s','%s',now(),'%s','%s')";
        sql = String.format(sql, book.getTitle(), book.getAuthor(), book.getAmount(), true);
        Connection con = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            int b = preparedStatement.executeUpdate();
            if (b > 0) {
                System.out.println("Book Success inserted !!! ");
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBook(Integer id, boolean b) {

    }

    public List<Book> bookList() {
        List<Book> bookList = new LinkedList<>();
        Connection con = dbConnection.getConnection();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from book");
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setAmount(resultSet.getString("amount"));
                book.setPublishYear(resultSet.getDate("publishyear").toLocalDate());
                book.setVisible(Boolean.parseBoolean(resultSet.getString("visible")));
                bookList.add(book);
            }
            con.close();
            return bookList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Book getBookById(Integer id) {
        return null;
    }

    public void deleteBook(Integer id,boolean visible) {

    }
}
////id,title,author, publishYear, amount, visible