package by.cources.spring.task5.spring.repository;

import by.cources.spring.task5.spring.model.Language;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaLanguageRepository implements LanguageRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<Language> findAll() {
        return em.createQuery("select lang from Language lang", Language.class).getResultList();
    }

    @Override
    @Transactional
    public Language findById(Long id) {
        return em.find(Language.class, id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Language save(Language language) {
        if (language.getId() == null) {
            em.persist(language);
            return language;
        } else {
            return em.merge(language);
        }
    }
}
