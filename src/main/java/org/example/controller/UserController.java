package org.example.controller;

import org.example.service.BookService;
import org.example.service.StudentBookService;
import org.example.util.Component;
import org.example.util.Scan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private Scan scanner;
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentBookService studentBookService;

    public void start() {
        boolean b = true;
        while (b) {
            switch (menu()) {
                case 1 -> bookList();
                case 2 -> takeBook();
                case 3 -> takenBook();
                case 4 -> returnBook();
                case 5 -> history();
                case 6 -> orderBook();
                default -> b = false;


            }
        }
    }
    private void bookList() {
        bookService.bookList();
    }
    private void takeBook() {
        System.out.print("Enter book id : ");
        studentBookService.takeBook(scanner.intScan().nextInt(),Component.student.getId());
    }
    private void takenBook() {
        studentBookService.takenBook(Component.student);
    }
    private void returnBook() {
        System.out.print("Enter book id : ");
        studentBookService.returnBook(scanner.intScan().nextInt(),Component.student.getId());
    }
    private void history() {
        studentBookService.history(Component.student.getId());
    }
    private void orderBook() {
    }
    public Integer menu() {
        System.out.println("--- User Menu ---");
        System.out.println("1. Book List :");
        System.out.println("2. Take book :");
        System.out.println("3.Taken book :");
        System.out.println("4.Return book :");
        System.out.println("5.History :");
        System.out.println("6.Order book :");
        System.out.print("Enter action : ");
        return scanner.intScan().nextInt();
    }
}

