package by.cources.spring.task4.spring.service;

import by.cources.spring.task4.spring.model.Author;
import by.cources.spring.task4.spring.model.Book;
import by.cources.spring.task4.spring.model.Language;

import java.util.List;
import javax.transaction.Transactional;

public interface BookService {

  List<Book> findBooksAll();

  List<Language> findLanguageAll();

  @Transactional
  Author saveAuthor(Author author);

  @Transactional
  Book saveBook(Book book);

  @Transactional
  Language saveLanguage(Language language);

  List<Author> findAuthorsWithBookOlderThan(Long value);

  List<Book> findBooksWithBookOlderThan(Long value);

  List<Book> findBooksWithBookName(String value);

  List<Author> findAuthorsAll();



}
