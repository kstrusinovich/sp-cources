package by.cources.spring.task6.service;

import by.cources.spring.task6.model.Author;
import by.cources.spring.task6.model.Book;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

public interface BookService {

  List<Book> findBooksAll();

//  @Transactional
//  void deleteById(Long id);

  @Transactional
  Author saveAuthor(Author author);

  List<Author> findAuthorsWithBookOlderThan(Long value);

  List<Book> findBooksWithBookOlderThan(Long value);

  List<Book> findBooksWithBookName(String value);

  List<Author> findAuthorsAll();

  Book saveBook(Book book);
//  Book deleteBook(Book book);

  @Transactional
//  void deleteById(Long id);
  void delete(long id);
  List<Book> findByIdBook(Long value);

//  List<Author> findAuthorByName(String firstName, String lastName);

//  Optional<Author> findAuthorById(Long id);
}
