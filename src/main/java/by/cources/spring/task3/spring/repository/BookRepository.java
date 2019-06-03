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
	
	@Query("select a from Book a join a.language b where b.name = :value")
	List<Book> findBooksByLang(@Param("value") String value);
}
