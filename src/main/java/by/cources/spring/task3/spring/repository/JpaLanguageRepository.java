package by.cources.spring.task3.spring.repository;

import by.cources.spring.task3.spring.model.Language;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class JpaLanguageRepository implements LanguageRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Optional<Language> findById(Long id) {
		return Optional.ofNullable(em.find(Language.class, id));
	}
}
