package org.example.controller;

import org.example.service.BookService;
import org.example.service.StudentBookService;
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
        bookService.booklist();
    }

    private void takeBook() {

    }

    private void takenBook() {

    }

    private void returnBook() {

    }

    private void history() {

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


/*--- User Menu ---
1. Book bist (kitoblar)
  OrderNumber  BookTitle  BookAuthor
2. Take book (kitob olish)
  Enter book Id

  (bitta student bir vaqtni o'zida 5ta kitob olishi mumkun.
   Ya'ni studentning olgan hali qaytarmagan kitoblar soni 5ga teng bo'lsa unga boshqa kitob berilmaydi.)
   Agar kitob qolmagan bo'lsa berilmasin.
3. Taken book (Olib lekin qaytarmagan kitoblar)
  Studentni olib hali qaytarmagan kitoblari. Konsolga quyidagilar chiqsin
    OrderNumber  BookTitle  BookAuthor TakenTime (kitobni olgan vaqti)
4. Return book
  Enter book id:

5. History (Shu studentni barcha olgan  topshirgan yoki hali topshirmagan kitoblar ro'yhati)
  Studentni olib qaytargan yoki olib hali qaytarmagan kitoblar tarixi.
  Konsolga quyidagilar chiqsin
    OrderNumber   BookTitle   BookAuthor   Status  TakenDate (kitobni olgan vaqti)    returnedDate

6. Order book (qandaydir kitob bo'lmasa kutubhonachida shu kitobni olib kelinglar deb yozish mumkun.)
  Enter book name:*/