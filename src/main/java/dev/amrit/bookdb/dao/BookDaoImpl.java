package dev.amrit.bookdb.dao;

import dev.amrit.bookdb.model.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.TransactionManager;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDAO {


    @PersistenceContext
    private EntityManager em;

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
       CriteriaQuery<Book> bookCriteriaQuery= em.getCriteriaBuilder().createQuery(Book.class);
       Root<Book> root = bookCriteriaQuery.from(Book.class);
       return em.createQuery(bookCriteriaQuery).getResultList();
    }

    @Override
    public void update(Integer id, Book book) {

    }

    @Override
    public void delete(Integer id) {

    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
