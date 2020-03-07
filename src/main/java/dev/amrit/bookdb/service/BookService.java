package dev.amrit.bookdb.service;



import dev.amrit.bookdb.model.Book;

import java.util.List;

public interface BookService {

    Book get(Integer id);

    List<Book> List();

    Book saveOrUpdate(Book book);

    void delete(Integer id);
}
