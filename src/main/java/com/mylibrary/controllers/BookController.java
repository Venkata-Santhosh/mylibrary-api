package com.mylibrary.controllers;

import com.mylibrary.entities.Book;
import com.mylibrary.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mylibrary")
@Api("Books controller")
public class BookController {

    private BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ApiOperation(
        value = "query book by id",
        notes = "return all books from database"
    )
    @ApiResponses( value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Internal Server Error")
        }
    )
    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Book> queryBookById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bookService.queryBookById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<Book>> queryForAllBooks() {
        return new ResponseEntity<>(bookService.queryForAllBooks(), HttpStatus.OK);
    }

//    private Book addBooks() {
//        Author author = new Author();
//        author.setName("santhosh");
//        Publisher publisher = new Publisher();
//        publisher.setName("COX");
//        Set<Author> authorSet = new HashSet<>();
//        authorSet.add(author);
//
//        Book book = new Book();
//        book.setAuthors(authorSet);
//        book.setPublisher(publisher);
//        book.setTitle("java");
//
//        return book;
//    }
}
