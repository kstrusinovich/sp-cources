package by.cources.spring.task6.repository;

import by.cources.spring.task6.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DelBookRepository extends CrudRepository<Book, Long> {

    @Query("delete from Book b where b.publishedIn >= :value")
    List<Book> findOlderThan(@Param("value") Long value);

    List<Book> findByName(String name);
}