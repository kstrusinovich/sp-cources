package by.cources.spring.task3.spring.service;

import by.cources.spring.task3.spring.model.Author;
import by.cources.spring.task3.spring.model.Book;
import by.cources.spring.task3.spring.model.Language;

import java.util.List;

public interface SearchService {

  List<Book> findBooksAll();
  
  List<Book> findBooksWithBookOlderThan(Long value);

  List<Book> findBooksWithBookName(String value);

  List<Author> findAuthorsWithBookOlderThan(Long value);

  List<Author> findAuthorsAll();
  
  List<Language> findLanguagesAll();
  
  List<Book> findBooksByLanguage(String language);
  
  List<Author> findAuthorsByLanguage(String language);
}
