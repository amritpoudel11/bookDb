package dev.amrit.bookdb.controller;

import dev.amrit.bookdb.model.Book;
import dev.amrit.bookdb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    //get all books
    @GetMapping("/books")
    public ResponseEntity<List<Book>> list(){
        List<Book> list = bookService.List();
        return ResponseEntity.ok().body(list);
    }
}
