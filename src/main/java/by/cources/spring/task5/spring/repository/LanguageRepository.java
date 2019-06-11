package by.cources.spring.task5.spring.repository;

import java.util.List;
import by.cources.spring.task5.spring.model.Language;


public interface LanguageRepository {

    List<Language> findAll();

    Language findById(Long id);

    Language save(Language language);
}
