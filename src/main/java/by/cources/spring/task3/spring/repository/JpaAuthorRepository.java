package by.cources.spring.task3.spring.repository;

import by.cources.spring.task3.spring.model.Author;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class JpaAuthorRepository implements AuthorRepository 
{
	@PersistenceContext
	private EntityManager em;

  
	@Override
	public List <Author> findWithBookOlderThan(Long value) 
	{
		String hql = "select distinct a from Author a join a.books b where b.publishedIn >= :value";
		TypedQuery<Author> query = em.createQuery(hql, Author.class);
		query.setParameter("value", value);
		return query.getResultList();
	}

	@Override
	public Optional<Author> findById(Long id)
	{
		return Optional.ofNullable(em.find(Author.class, id));
	}

	@Override
	public List<Author> findAll()
	{
		return em.createQuery("select a from Author a", Author.class).getResultList();
	}

	@Override
	public List<Author> findWithBookOnLanguage(Long value) {
		String hql = "select distinct a from Author a join a.books b where b.publishedIn >= :value";
		TypedQuery<Author> query = em.createQuery(hql, Author.class);
		query.setParameter("value", value);
		return query.getResultList();		
	}

	@Override
	public List<Author> findAuthorsWithBookOnLanguage(String languageName) 
	{
		String hql = "select distinct a from Author a join a.books b where b.language = "
				+ "(select l from Language l where l.name = :value)";
		TypedQuery<Author> query = em.createQuery(hql, Author.class);
		query.setParameter("value", languageName);
		return query.getResultList();		
	}
	
	public List<Author> findAuthorsWithBooksOnLanguageAfterYear(String languageName, Long year) 
	{
		String hql = "select distinct a from Author a join a.books b where b.language = "
				+ "(select l from Language l where l.name = :value) and b.publishedIn >= :value2";
		TypedQuery<Author> query = em.createQuery(hql, Author.class);
		query.setParameter("value", languageName);
		query.setParameter("value2", year);
		return query.getResultList();		
	}
	
	  
}