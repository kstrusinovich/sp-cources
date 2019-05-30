package by.cources.spring.task1.Sharay.repository;

import by.cources.spring.task1.Sharay.Book;

import java.util.Arrays;
import java.util.List;

public class MysqlBookRepository implements BookRepository {

  private List<Book> cache = Arrays.asList(
      new Book("myst-book1"),
      new Book("mars-book2"),
      new Book("bmv-book3")
  );

  @Override
  public List<Book> findAll() {
    return cache;
  }
}
