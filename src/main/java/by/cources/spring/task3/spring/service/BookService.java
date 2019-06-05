package by.cources.spring.task3.spring.service;

import by.cources.spring.task3.spring.model.Author;
import by.cources.spring.task3.spring.model.Book;
import java.util.List;

public interface BookService {

  List<Book> findBooksAll();

  List<Author> findAuthorsWithBookOlderThan(Long value);

  List<Author> findAuthorsWithLanguageIs(String value);

  List<Author> findAuthorsWithLanguageAndDate(String value, Long year);

  List<Book> findBooksWithBookOlderThan(Long value);

  List<Book> findBooksWithBookLanguage(String value);

  List<Book> findBooksWithBookName(String value);

  List<Author> findAuthorsAll();
}
