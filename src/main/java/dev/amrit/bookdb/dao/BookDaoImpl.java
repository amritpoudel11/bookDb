package dev.amrit.bookdb.dao;

import dev.amrit.bookdb.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDAO {


    @PersistenceContext
    private EntityManager em;

    @Override
    public Book get(Integer id) {
        return em.find(Book.class, id);
    }

    @Override
    public List<Book> List() {
       CriteriaQuery<Book> bookCriteriaQuery= em.getCriteriaBuilder().createQuery(Book.class);
       Root<Book> root = bookCriteriaQuery.from(Book.class);
       return em.createQuery(bookCriteriaQuery).getResultList();
    }

    @Override
    public Book saveOrUpdate(Book book) {
        return em.merge(book);
    }

    @Override
    public void delete(Integer id) {
        em.remove(em.find(Book.class, id));
    }

}
