package by.cources.spring.task4.spring.repository;


import by.cources.spring.task4.spring.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public abstract class JpaBookRepository implements BookRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  @Transactional
  public List<Book> findAll() {
    return em.createQuery("select a from Book a", Book.class).getResultList();
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Book save(Book book) {
    if (book.getId() == null) {
      em.persist(book);
      return book;
    } else {
      return em.merge(book);
    }
  }
}
