package dev.amrit.bookdb.dao;

import dev.amrit.bookdb.model.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer save(Book book) {
        return null;
    }

    @Override
    public Book get(Integer id) {
        return null;
    }

    @Override
    public List<Book> List() {
       List<Book> bookList = sessionFactory.getCurrentSession().createQuery("from Book").list();
       return bookList;
    }

    @Override
    public void update(Integer id, Book book) {

    }

    @Override
    public void delete(Integer id) {

    }
}
