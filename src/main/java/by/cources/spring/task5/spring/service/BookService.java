package by.cources.spring.task5.spring.service;

import by.cources.spring.task5.spring.model.Author;
import by.cources.spring.task5.spring.model.Book;
import by.cources.spring.task5.spring.model.Language;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

public interface BookService {

  List<Book> findBooksAll();

  Author saveAuthor(Author author);

  Book saveBook(Book book);

  Book saveBookOnly(Book book);

  Book saveBookAndNewLang(Book book);

  Language saveLanguage(Language language);

  List<Author> findAuthorsWithBookOlderThan(Long value);

  List<Author> findAuthorsAll();

  List<Book> findBooksWithBookOlderThan(Long value);

  List<Book> findBooksWithBookName(String value);

  Optional<Book> findBookById(Long value);

  List<Language> findLanguagesAll();

  Language findLanguageById(Long value);

  public void delBook(Book book) ;

}
