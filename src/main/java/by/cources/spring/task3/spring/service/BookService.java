package by.cources.spring.task3.spring.service;

import by.cources.spring.task3.spring.model.Author;
import by.cources.spring.task3.spring.model.Book;
import by.cources.spring.task3.spring.model.Language;
import java.util.List;

public interface BookService {

  List<Book> findBooksAll();

  List<Author> findAuthorsWithBookOlderThan(Long value);

  List<Book> findBooksWithBookOlderThan(Long value);

  List<Book> findBooksWithBookName(String value);

  List<Author> findAuthorsAll();

  List<Language> findLanguagesAll();
  List<Book> findBookByLanguage(String value);
  List<Author> findAuthorByLanguage(String value);
  List<Author> findAuthorByLanguageOlderThen(String value,Long year);
}
