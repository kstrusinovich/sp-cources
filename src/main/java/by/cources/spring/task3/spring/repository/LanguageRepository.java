package by.cources.spring.task3.spring.repository;

import by.cources.spring.task3.spring.model.Language;

import java.util.List;

public interface LanguageRepository {

    List<Language> findAll();
}
