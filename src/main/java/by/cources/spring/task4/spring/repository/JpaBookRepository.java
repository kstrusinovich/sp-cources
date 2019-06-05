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
public class JpaBookRepository implements BookRepository {

  @PersistenceContext
  private EntityManager em;
  @Override
  @Transactional
  public List<Book> findOlderThan(Long value) {
    String hql = "select b from Book b where b.publishedIn >= :value";
    TypedQuery<Book> query = em.createQuery(hql, Book.class);
    query.setParameter("value", value);
    return query.getResultList();
  }
  @Override
  @Transactional
  public List<Book> findByName(String value) {
    return em.createQuery("select a from Book a where a.name=:value", Book.class).getResultList();
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public Iterable<Book> findAllById(Iterable<Long> longs) {
    return null;
  }

  @Override
  public Iterable<Book> findAll() {
    return null;
  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }

  @Override
  public Optional<Book> findById(Long aLong) {
    return Optional.empty();
  }

  @Override
  public <S extends Book> Iterable<S> saveAll(Iterable<S> entities) {
    return null;
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
