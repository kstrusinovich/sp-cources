package by.cources.spring.task1.lesya.repository;

import by.cources.spring.task1.lesya.Book;

import java.util.Arrays;
import java.util.List;

public class MysqlBookRepository implements BookRepository {

  private List<Book> cache = Arrays.asList(
      new Book("Lesya-book1"),
      new Book("Lesya-book2")
  );

  @Override
  public List<Book> findAll() {
    return cache;
  }
}