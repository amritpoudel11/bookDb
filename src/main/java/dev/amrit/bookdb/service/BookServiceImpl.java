package dev.amrit.bookdb.service;


import dev.amrit.bookdb.dao.BookDAO;
import dev.amrit.bookdb.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public Book get(Integer id) {
        return bookDAO.get(id);
    }

    @Override
    @Transactional
    public List<Book> List() {
       return bookDAO.List();
    }

    @Override
    @Transactional
    public Book saveOrUpdate(Book book) {
    return bookDAO.saveOrUpdate(book);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        bookDAO.delete(id);
    }
}
