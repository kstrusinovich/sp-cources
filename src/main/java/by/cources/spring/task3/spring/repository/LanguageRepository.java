package by.cources.spring.task3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import by.cources.spring.task3.spring.model.Language;

public interface LanguageRepository extends CrudRepository<Language, Long> {

	  List<Language> findAll();
	
}
