package by.cources.spring.task6.service;

import by.cources.spring.task6.model.Author;
import by.cources.spring.task6.model.Book;
import java.util.List;
import javax.transaction.Transactional;
import java.util.Optional;
public interface BookService {

  List<Book> findBooksAll();

  @Transactional
  Author saveAuthor(Author author);

  List<Author> findAuthorsWithBookOlderThan(Long value);

  List<Book> findBooksWithBookOlderThan(Long value);

  List<Book> findBooksWithBookName(String value);

  List<Author> findAuthorsAll();

  Book saveBook(Book book);

  void deleteBook(Long id);

  Optional<Book> findBookById(Long id);


}
