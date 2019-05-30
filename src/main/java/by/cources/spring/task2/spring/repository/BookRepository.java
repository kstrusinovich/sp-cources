package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.model.Author;
import java.util.List;

public interface BookRepository {

  List<Book> findAll();

  Book findById(Long id);

  List<Author> findAll();

  Author findById(Long id);
}
