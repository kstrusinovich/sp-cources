package by.cources.spring.task6.service;

import by.cources.spring.task6.model.Author;
import by.cources.spring.task6.model.Book;
import java.util.List;
import javax.transaction.Transactional;

public interface BookService {

  List<Book> findBooksAll();

  @Transactional
  Author saveAuthor(Author author);

  List<Author> findAuthorsWithBookOlderThan(Long value);

  List<Book> findBooksWithBookOlderThan(Long value);

  List<Book> findBooksWithBookName(String value);

  List<Author> findAuthorsAll();

  Book saveBook(Book book);

<<<<<<<<< Temporary merge branch 1
  void deleteBook(Book book);

  Book getBookById(Long id);
=========
  Optional<Book> findBookById(Long id);
>>>>>>>>> Temporary merge branch 2
}
