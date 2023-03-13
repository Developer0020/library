package org.example.controller;

import org.example.dto.Book;
import org.example.dto.Student;
import org.example.repository.StudentRepository;
import org.example.service.BookService;
import org.example.service.StudentBookService;
import org.example.service.UserService;
import org.example.util.Scan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
    @Autowired
    private Scan scanner;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentBookService studentBookService;

    public void start() {
        boolean b = true;
        while (b) {
            switch (menu()) {
                case 1 -> bookList();
                case 2 -> addBook();
                case 3 -> deleteBook();
                case 4 -> studentList();
                case 5 -> addStudent();
                case 6 -> deleteStudent();
                case 7 -> studentTakenBook();
                case 8 -> bookTakenHistory();
                default -> b = false;
            }
        }
    }

    private Integer menu() {
        System.out.println("--- Admin Menu ---");
        System.out.println("1.Book List :");
        System.out.println("2.Add Book :");
        System.out.println("3.Delete Book :");
        System.out.println("4.Student List :");
        System.out.println("5.Add Student :");
        System.out.println("6.Delete Student :");
        System.out.println("7.Student Taken Book :");
        System.out.println("8.Book Taken History :");
        System.out.print("Enter action :");
        return scanner.intScan().nextInt();
    }

    private void bookList() {
        bookService.bookList();
    }
    private void addBook() {
        Book book = new Book();
        System.out.print("Enter title : ");
        book.setTitle(scanner.stringScan().nextLine());
        System.out.print("Enter author : ");
        book.setAuthor(scanner.stringScan().nextLine());
        System.out.print("Enter amount : ");
        book.setAmount(scanner.stringScan().nextLine());
        bookService.addBook(book);
    }
    private void deleteBook() {
        System.out.print("Enter id :");
        Integer id = scanner.intScan().nextInt();
        bookService.deleteBook(id, false);
    }
    private void studentList() {
        userService.studentList();
    }
    private void addStudent() {
        Student student = new Student();
        System.out.print("Enter name:");
        student.setName(scanner.stringScan().nextLine());
        System.out.print("Enter surname :");
        student.setSurname(scanner.stringScan().nextLine());
        System.out.print("Enter phone :");
        student.setPhone(scanner.stringScan().nextLine());
        userService.addStudent(student);
    }
    private void deleteStudent() {
        System.out.print("Enter student id :");
        userService.deleteStudent(scanner.intScan().nextInt(), false);
    }
    private void studentTakenBook() {
       studentBookService.takenBook();
    }
    private void bookTakenHistory() {
        studentBookService.bookTakenHistory();
    }
}
