package by.cources.spring.task4.spring.repository;

import by.cources.spring.task4.spring.model.Language;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

    
}
