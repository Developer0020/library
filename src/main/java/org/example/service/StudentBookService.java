package org.example.service;

import org.example.dto.Student;
import org.example.dto.StudentBook;
import org.example.enums.Status;
import org.example.repository.BookRepository;
import org.example.repository.StudentBookRepository;
import org.example.util.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
@Service
public class StudentBookService {
    @Autowired
    private StudentBookRepository studentBookRepository;
    @Autowired
    private BookRepository bookRepository;
    public void takeBook(Integer book_id,Integer student_id) {
        if (studentBookRepository.studentBookListByStudentId(Component.student.getId()).size() > 6) {
            System.err.println("Mazgibek sizda 5 kitob bor ekan bittasini qaytaring oldin !!!");
        } else if (Integer.valueOf(bookRepository.getBookById(book_id).getAmount()) > 0) {
            StudentBook studentBook = new StudentBook();
            studentBook.setStudent_id(student_id);
            studentBook.setBook_id(book_id);
            studentBook.setStatus(Status.TAKEN);
            studentBookRepository.takeBook(studentBook);
        } else {
            System.err.printf("Bu kitobdan qolmagan yoki id ni xato kiritdingiz !!! ");
        }
    }
    public void takenBook(Student student) {
        studentBookRepository.studentBookListByStudentId(student.getId()).stream().filter
                (studentBook -> studentBook.getStatus().equals(Status.TAKEN)).forEach(System.out::println);
    }
    public void takenBook() {
        studentBookRepository.studentBookList().stream().filter(studentBook -> studentBook.getStatus().equals(Status.TAKEN)).forEach(System.out::println);
    }
    public void returnBook(Integer book_id, Integer student_id) {
        if (studentBookRepository.studentBook(book_id, student_id) == null) {
            System.err.printf("Not found Pages !!! ");
        } else if (studentBookRepository.studentBook(book_id, student_id).getStatus().equals(Status.TAKEN)) {
            LocalDate createdDate = studentBookRepository.studentBook(book_id, student_id).getCreatedDate();
            LocalDate returnedDate = LocalDate.now();
            long days = ChronoUnit.DAYS.between(createdDate, returnedDate);
            studentBookRepository.returnedBook(book_id, student_id, String.valueOf(days));
        }
    }
    public void history(Integer student_id) {
        studentBookRepository.studentBookListByStudentId(student_id).stream().forEach(System.out::println);
    }
    public void bookTakenHistory() {
        studentBookRepository.studentBookList().stream().forEach(System.out::println);
    }
}
