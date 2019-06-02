package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.repository.BookRepository;

import java.util.List;

public class BookService {

  private BookRepository repository;

  public BookService(BookRepository repository) {
    this.repository = repository;
  }

  public List<Book> findAll() {
    return repository.findAll();
  }

  public Book findById(Long id){
    return repository.findById(id);}
}
