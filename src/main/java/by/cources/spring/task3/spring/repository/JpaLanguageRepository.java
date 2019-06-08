package by.cources.spring.task3.spring.repository;

import by.cources.spring.task3.spring.model.Language;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaLanguageRepository implements LanguageRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Language> findAll() {
        return em.createQuery("select lang from Language lang", Language.class).getResultList();
    }
}
