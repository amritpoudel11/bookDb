package dev.amrit.bookdb.dao;



import dev.amrit.bookdb.model.Book;

import java.util.List;

public interface BookDAO {

    Book get(Integer id);

    List<Book> List();

    Book saveOrUpdate(Book book);

    void delete(Integer id);
}
