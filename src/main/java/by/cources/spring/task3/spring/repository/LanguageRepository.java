package by.cources.spring.task3.spring.repository;

import by.cources.spring.task3.spring.model.Language;

import java.util.Optional;

public interface LanguageRepository {

  Optional<Language> findById(Long id);

}

