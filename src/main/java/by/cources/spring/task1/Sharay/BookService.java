package by.cources.spring.task1.Sharay;

import by.cources.spring.task1.Sharay.Book;
import by.cources.spring.task1.Sharay.repository.BookRepository;

import java.util.List;

public class BookService {

  private BookRepository repository;

  public BookService(BookRepository repository) {
    this.repository = repository;
  }

  public List<Book> findAll() {
    return repository.findAll();
  }
}
