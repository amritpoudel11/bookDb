package dev.amrit.bookdb.controller;

import dev.amrit.bookdb.dao.BookDAO;
import dev.amrit.bookdb.model.Book;
import dev.amrit.bookdb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    //get all books
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> list = bookService.List();
        return ResponseEntity.ok().body(list);
    }

    //get book by id
    @RequestMapping(method= RequestMethod.GET, path = "/{bookId}/book")
    public ResponseEntity<Book> getBook(@PathVariable Integer bookId){
        Book book = bookService.get(bookId);
        if( book == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
        //In other way return ResponseEntity.ok().body(book);
    }
    //save or edit/update book

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addBook(@Valid @RequestBody Book book, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder){

        if(bindingResult.hasErrors() || book.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Book savedBook = bookService.saveOrUpdate(book);
        UriComponents uriComponents = uriComponentsBuilder.path("/api/" + savedBook.getId()).build();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //update book
    @RequestMapping(method = RequestMethod.PUT, path="/{id}")
    public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book, BindingResult bindingResult, @PathVariable Integer id){

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (book.getId() != null && !book.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (bookService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        book.setId(id);
        bookService.saveOrUpdate(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //delete book
    @RequestMapping(method= RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Book> DeleteBook(@PathVariable Integer id){
            if(bookService.get(id) != null){
                bookService.delete(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
