package by.cources.spring.task5.spring.service;

import by.cources.spring.task5.spring.model.Author;
import by.cources.spring.task5.spring.model.Book;
import by.cources.spring.task5.spring.model.Language;

import java.util.List;
import javax.transaction.Transactional;

public interface BookService {

  List<Book> findBooksAll();

    @org.springframework.transaction.annotation.Transactional
    void deleteById(Long id);

    @org.springframework.transaction.annotation.Transactional
    List<Language> findLanguagesAll();

    @Transactional
  Author saveAuthor(Author author);

  List<Author> findAuthorsWithBookOlderThan(Long value);

  List<Book> findBooksWithBookOlderThan(Long value);

  List<Book> findBooksWithBookName(String value);

  List<Author> findAuthorsAll();

  Book saveBook(Book book);
}
