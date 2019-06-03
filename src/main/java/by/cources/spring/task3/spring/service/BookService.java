package by.cources.spring.task3.spring.service;

import by.cources.spring.task3.spring.model.Author;
import by.cources.spring.task3.spring.model.Book;
import by.cources.spring.task3.spring.model.Language;

import java.util.List;

import org.springframework.data.repository.query.Param;

public interface BookService {

  List<Book> findBooksAll();

  List<Author> findAuthorsWithBookOlderThan(Long value);

  List<Book> findBooksWithBookOlderThan(Long value);

  List<Book> findBooksWithBookName(String value);

  List<Author> findAuthorsAll();
  
  List<Book> findBooksByLanguage(String value);
}
