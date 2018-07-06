package com.mylibrary.services;

import com.mylibrary.entities.Book;
import com.mylibrary.exceptions.BookNotFoundException;
import com.mylibrary.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> queryForAllBooks() {
        return bookRepository.findAll();
    }

    public Book queryBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(
            () ->  new BookNotFoundException("Book not found")
        );
    }
}
