package by.cources.spring.task6.repository;


import by.cources.spring.task6.model.Book;
import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

  @Query("select b from Book b where b.publishedIn >= :value")
  List<Book> findOlderThan(@Param("value") Long value);

 // List<Book> findByName(String name);
  @Query("select b from Book b where b.id = :value")
  List<Book> findByIdBook(@Param("value") Long value);
  //@Query("update Book set name = :value1,  published_in = :value2 where id = :value ")
  //List<Book> updateBook(@Param("value") Long value,@Param(value = book.name));
  @Override
  void deleteById(Long aLong);
  @Query("select b from Book b where b.name = :value")
  List<Book> findByName(@Param("value") String value);




}
