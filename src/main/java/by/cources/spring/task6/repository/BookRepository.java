package by.cources.spring.task6.repository;

import by.cources.spring.task6.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
// @Repository показывает, что класс функционирует как репозиторий
// и требует наличия прозрачной трансляции исключений.
// Преимуществом трансляции исключений является то,
// что слой сервиса будет иметь дело с общей иерархией исключений от Spring (DataAccessException)
// вне зависимости от используемых технологий доступа к данным в слое данных.
public interface BookRepository extends CrudRepository<Book, Long> {

  @Query("select b from Book b where b.publishedIn >= :value")
  List<Book> findOlderThan(@Param("value") Long value);

  List<Book> findByName(String name);
}
