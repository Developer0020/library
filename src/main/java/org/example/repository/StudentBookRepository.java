package org.example.repository;

import org.example.dto.Book;
import org.example.dto.StudentBook;
import org.example.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

@Repository
public class StudentBookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BookRepository bookRepository;

    public void takeBook(StudentBook studentBook) {
        String sql = "Insert into studentBook(student_id,book_id,createdDate,status,) values ('%s','%s','%s','%s')";
        sql = String.format(sql, studentBook.getStudent_id(), studentBook.getBook_id(), studentBook.getStatus());
        int n = jdbcTemplate.update(sql);
        if (n > 0) {
            System.out.println("Success !");
            bookRepository.updateBook
                    (studentBook.getBook_id(), String.valueOf(Integer.valueOf(bookRepository.getBookById(studentBook.getBook_id()).getAmount()) - 1));
        }
        //id,student_id,book_id,createdDate,status(TAKEN,RETURNED),returnedDate,duration
 /*2. Take book (kitob olish)
  Enter book Id

  (bitta student bir vaqtni o'zida 5ta kitob olishi mumkun.
   Ya'ni studentning olgan hali qaytarmagan kitoblar soni 5ga teng bo'lsa unga boshqa kitob berilmaydi.)
   Agar kitob qolmagan bo'lsa berilmasin.*/
    }

    public StudentBook studentBookListByBookId(Integer book_id, Integer student_id) {
        String sql = "Select * from studentBook where book_id = '%s' and student_id ='%s'";
        sql = String.format(sql, book_id, student_id);
        return (StudentBook) jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentBook.class));
    }

    public List<StudentBook> studentBookListByStudentId(Integer student_id) {
        String sql = "Select * from studentBook where student_id = '%s'";
        sql = String.format(sql, student_id);
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentBook.class));
    }

    public void returnedBook(Integer book_id, Integer student_id, String duration) {
        String sql = "update studentBook set status = '%s',returneddate=now(),duration='%s' where  book_id='%s' and student_id='%s'  ";
        sql = String.format(sql, Status.RETURNED.name(), duration, book_id, student_id);
        int effectedRows = jdbcTemplate.update(sql);
        if (effectedRows>0){
            System.out.println("Success !");
            bookRepository.updateBook(book_id, String.valueOf(Integer.valueOf(bookRepository.getBookById(book_id).getAmount())+1));

        }
    }
}
