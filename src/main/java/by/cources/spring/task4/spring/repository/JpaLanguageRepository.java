package by.cources.spring.task4.spring.repository;

import by.cources.spring.task4.spring.model.Author;
import by.cources.spring.task4.spring.model.Language;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaLanguageRepository implements LanguageRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Language> findAll() {
        return em.createQuery("select lang from Language lang", Language.class).getResultList();
    }

    @Override
    public Language findById(Long id) {
        return em.find(Language.class, id);
    }
}
