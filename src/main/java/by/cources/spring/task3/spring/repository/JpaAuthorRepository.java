package by.cources.spring.task3.spring.repository;

import by.cources.spring.task3.spring.model.Author;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class JpaAuthorRepository implements AuthorRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public List<Author> findWithBookOlderThan(Long value) {
    String hql = "select a from Author a join a.books b where b.publishedIn >= :value";
    TypedQuery<Author> query = em.createQuery(hql, Author.class);
    query.setParameter("value", value);
    return query.getResultList();
  }

  @Override
  public Optional<Author> findById(Long id) {
    return Optional.ofNullable(em.find(Author.class, id));
  }

  @Override
  public List<Author> findAll() {
    return em.createQuery("select a from Author a", Author.class).getResultList();
  }

  @Override
  public List<Author> findWithLanguageIs(String value) {
    String hq = "select a from Author a where a.language.name = :value";
    TypedQuery<Author> query = em.createQuery(hq, Author.class);
    query.setParameter("value", value);
    return query.getResultList();
  }

  @Override
  public List<Author> findWithLanguageAndDate(String value, Long year) {
    String hq = "select distinct a from Author a join a.books b where b.language.name = :value and b.publishedIn > :year";
    TypedQuery<Author> query = em.createQuery(hq, Author.class);
    query.setParameter("value", value);
    query.setParameter("year", year);
    return query.getResultList();
  }
}
