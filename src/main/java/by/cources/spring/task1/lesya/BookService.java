package by.cources.spring.task1.lesya;

import by.cources.spring.task1.lesya.Book;
import by.cources.spring.task1.lesya.repository.BookRepository;

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
