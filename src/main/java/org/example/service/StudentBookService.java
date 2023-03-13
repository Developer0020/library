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

    public void takeBook(Integer id) {
        if (Integer.valueOf(bookRepository.getBookById(id).getAmount()) > 0) {
            StudentBook studentBook = new StudentBook();
            studentBook.setStudent_id(Component.student.getId());
            studentBook.setBook_id(id);
            studentBook.setStatus(Status.TAKEN);
            studentBook.setCreatedDate(LocalDate.now());
            studentBookRepository.takeBook(studentBook);
        } else {
            System.err.printf("Bu kitobdan qolmagan yoki id ni xato kiritdingiz !!! ");
        }

        /*2. Take book (kitob olish)
  Enter book Id

  (bitta student bir vaqtni o'zida 5ta kitob olishi mumkun.
   Ya'ni studentning olgan hali qaytarmagan kitoblar soni 5ga teng bo'lsa unga boshqa kitob berilmaydi.)
   Agar kitob qolmagan bo'lsa berilmasin.*/
        // id,student_id,book_id,createdDate,status(TAKEN,RETURNED),returnedDate,duration
    }

    public void takenBook(Student student) {
        studentBookRepository.studentBookListByStudentId(student.getId()).stream().filter
                (studentBook -> studentBook.getStatus().equals(Status.TAKEN)).forEach(System.out::println);
        /* Studentni olib hali qaytarmagan kitoblari. Konsolga quyidagilar chiqsin
    OrderNumber  BookTitle  BookAuthor TakenTime (kitobni olgan vaqti)*/
    }

    public void returnBook(Integer book_id, Integer student_id) {
        if (studentBookRepository.studentBookListByBookId(book_id, student_id) == null) {
            System.err.printf("Not found Pages !!! ");
        } else if (studentBookRepository.studentBookListByBookId(book_id, student_id).getStatus().equals(Status.TAKEN)) {
            LocalDate createdDate =studentBookRepository.studentBookListByBookId(book_id, student_id).getCreatedDate();
            LocalDate returnedDate = LocalDate.now();
            long days = ChronoUnit.DAYS.between(createdDate,returnedDate);
            studentBookRepository.returnedBook(book_id, student_id,String.valueOf(days));
        }
    }

    public void history(Integer student_id) {
        studentBookRepository.studentBookListByStudentId(student_id).stream().forEach(System.out::println);
    }

}
/*Student Taken book (studentlar olib hali qaytarmagan kitoblar ro'yhati.)
  Konsolga quyidagilar chiqsin*/