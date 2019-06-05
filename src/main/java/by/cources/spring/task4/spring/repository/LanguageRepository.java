package by.cources.spring.task4.spring.repository;

import by.cources.spring.task4.spring.model.Language;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Shpakovski on 05.06.2019.
 */
public interface LanguageRepository extends CrudRepository<Language, Long> {
}
