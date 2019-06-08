package by.cources.spring.task3.spring.repository;

import by.cources.spring.task3.spring.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

  @Query("select b from Book b where b.publishedIn >= :value")
  List<Book> findOlderThan(@Param("value") Long value);

  List<Book> findByName(String name);

  @Query("SELECT b FROM Book b WHERE b.language IN (SELECT lang.id FROM Language lang WHERE lang.languageName= :value)")
  List<Book> findByLanguage(@Param("value") String value);
}
