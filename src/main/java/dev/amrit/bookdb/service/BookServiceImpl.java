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

    @Override
    public Integer save(Book book) {
        return null;
    }

    @Override
    public Book get(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public List<Book> List() {
       return bookDAO.List();
    }

    @Override
    public void update(Integer id, Book book) {

    }

    @Override
    public void delete(Integer id) {

    }
}
