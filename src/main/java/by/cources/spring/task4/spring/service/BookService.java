package by.cources.spring.task4.spring.service;

import by.cources.spring.task4.spring.model.Author;
import by.cources.spring.task4.spring.model.Book;
import by.cources.spring.task4.spring.model.Language;

import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;

public interface BookService {

  List<Book> findBooksAll();

  List<Author> findAuthorsWithBookOlderThan(Long value);

  List<Book> findBooksWithBookOlderThan(Long value);

  List<Book> findBooksWithBookName(String value);

  List<Author> findAuthorsAll();
  
  @Transactional
  Book saveBookAndLanguage(Author author, String bookName, Long year,
		  String languageName, boolean isDoubles);
  
  List<Language> findLanguagesAll();

  @Transactional
  Author saveAuthor(String lastName, String firstName, LocalDate dateOfBirth);
  
}
