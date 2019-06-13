package by.cources.spring.task6.service;

import by.cources.spring.task6.model.Book;
import java.util.List;
import javax.transaction.Transactional;

public interface BookService {

  List<Book> findBooksAll();

  List<Book> findBooksWithBookOlderThan(Long value);

  List<Book> findBooksWithBookName(String value);

  @Transactional
  void saveBook(String mode, Book book) throws Exception;

  Book findById(Long id);
}
