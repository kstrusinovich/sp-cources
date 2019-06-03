package by.cources.spring.task3.spring.repository;

import by.cources.spring.task3.spring.model.Book;
import by.cources.spring.task3.spring.model.Language;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class JpaLanguageRepository implements LanguageRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Language> findBooksByLanguage(String value) {
		String hql = "select a from Language a join a.books b where a.name = :value";
		TypedQuery<Language> query = em.createQuery(hql, Language.class);
		query.setParameter("value", value);
		return query.getResultList();
	}
		
	@Override
	public Optional<Language> findById(Long id) {
		return Optional.ofNullable(em.find(Language.class, id));
	}

	@Override
	public List<Book> findBooksByLang(String value) {
		String hql = "select a from Book a join Language b on a.languageId=b.languageId where b.name = :value";
		TypedQuery<Book> query = em.createQuery(hql, Book.class);
		query.setParameter("value", value);
		return query.getResultList();
	}
	
}
