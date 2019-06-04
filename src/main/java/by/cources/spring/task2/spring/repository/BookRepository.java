package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Book;
import java.util.List;

public interface BookRepository {

  List<Book> findAllBooks();

  Book findBookById(Long id);

}
