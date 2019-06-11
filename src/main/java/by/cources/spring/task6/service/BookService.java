package by.cources.spring.task6.service;

import by.cources.spring.task6.model.Book;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.validation.BindingResult;

public interface BookService {

  List<Book> findBooksAll();
 
  List<Book> findBooksWithBookOlderThan(Long value);

  List<Book> findBooksWithBookName(String value);

  @Transactional
  void saveBook(String mode, Book book, BindingResult result) throws Exception;

  Book getForm(String mode, Long id);
  
}
