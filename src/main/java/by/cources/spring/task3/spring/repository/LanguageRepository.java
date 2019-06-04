package by.cources.spring.task3.spring.repository;

import by.cources.spring.task3.spring.model.Language;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Shpakovski on 04.06.2019.
 */
public interface LanguageRepository extends CrudRepository<Language, Long> {

    List<Language> findAll();
}
