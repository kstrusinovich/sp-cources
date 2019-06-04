package by.cources.spring.task3.spring.repository;

import by.cources.spring.task3.spring.model.Language;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

  List<Language> findAll();

}
