package by.cources.spring.task1.Kostik.repository;

import by.cources.spring.task1.Kostik.Book;

import java.util.Arrays;
import java.util.List;

public class InMemoryBookRepository implements BookRepository {

  private List<Book> cache = Arrays.asList(
      new Book("book1"),
      new Book("book2"),
      new Book("book3")
  );

  @Override
  public List<Book> findAll() {
    return cache;
  }
}
