package org.example.service;

import org.example.dto.Book;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void bookList() {
        if (bookRepository.bookList()==null){
            System.err.println("kitob yo'q mazgi !!!");
            return;
        }
        bookRepository.bookList().stream().forEach(System.out::println);
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }


    public void deleteBook(Integer id, boolean visible) {
        if (bookRepository.getBookById(id) == null) {
            System.err.println("bunday idLi kitob mavju emas !");
        } else {
            bookRepository.updateBook(id, visible);
        }
    }
}
