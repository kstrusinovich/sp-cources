package by.cources.spring.task1.voschilo.repository;

import by.cources.spring.task1.voschilo.Book;
import java.util.Arrays;
import java.util.List;

public class MysqlBookRepository implements BookRepository {

  private List<Book> cache = Arrays.asList(
      new Book("mysq-book1"),
      new Book("mysq-book2")
  );

  @Override
  public List<Book> findAll() {
    return cache;
  }
}
