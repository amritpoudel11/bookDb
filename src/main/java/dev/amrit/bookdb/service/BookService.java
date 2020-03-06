package dev.amrit.bookdb.service;



import dev.amrit.bookdb.model.Book;

import java.util.List;

public interface BookService {
    Integer save(Book book);

    Book get(Integer id);

    List<Book> List();

    void update(Integer id, Book book);

    void delete(Integer id);
}
