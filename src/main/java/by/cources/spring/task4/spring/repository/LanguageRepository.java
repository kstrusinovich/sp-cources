package by.cources.spring.task4.spring.repository;


import by.cources.spring.task4.spring.model.Language;

import java.util.List;

public interface LanguageRepository {

    List<Language> findAll();

    Language findById(Long id);

    Language save(Language language);
}
