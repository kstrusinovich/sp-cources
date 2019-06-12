package by.cources.spring.task5.spring.repository;

import by.cources.spring.task5.spring.model.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

	Language getByName(String languageName);
	Optional<Language> findById(Long id);
    
}
