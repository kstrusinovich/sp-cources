package by.cources.spring.task5.spring.service;

import by.cources.spring.task5.spring.model.Author;
import by.cources.spring.task5.spring.model.Book;
import by.cources.spring.task5.spring.model.Language;

import java.util.List;
import javax.transaction.Transactional;

public interface BookService {

  List<Book> findBooksAll();

  @Transactional
  Author saveAuthor(Author author);

  @Transactional
  Book saveBook(Book book);

  @Transactional
  Book saveBookOnly(Book book);

  @Transactional
  Book saveBookAndNewLang(Book book);

  @Transactional
  Language saveLanguage(Language language);

  List<Author> findAuthorsWithBookOlderThan(Long value);

  List<Book> findBooksWithBookOlderThan(Long value);

  List<Book> findBooksWithBookName(String value);

  List<Author> findAuthorsAll();

  List<Language> findLanguagesAll();

  Language findLanguageById(Long value);
}
