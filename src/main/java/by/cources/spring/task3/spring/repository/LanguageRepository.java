package by.cources.spring.task3.spring.repository;

import by.cources.spring.task3.spring.model.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

  Optional<Language> findById(Long id);

}
