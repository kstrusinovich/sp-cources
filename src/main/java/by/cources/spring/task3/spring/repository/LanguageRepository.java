package by.cources.spring.task3.spring.repository;

import by.cources.spring.task3.spring.model.Language;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> 
{
/*
  @Query("select b from Book b where b.publishedIn >= :value")
  List<Book> findOlderThan(@Param("value") Long value);

  List<Book> findByName(String name);
*/
	List <Language> findAll();
}
