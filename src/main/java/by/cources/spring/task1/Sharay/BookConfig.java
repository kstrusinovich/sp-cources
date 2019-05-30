package by.cources.spring.task1.Sharay;

import by.cources.spring.task1.Sharay.BookService;
import by.cources.spring.task1.Sharay.repository.BookRepository;
import by.cources.spring.task1.Sharay.repository.InMemoryBookRepository;
import by.cources.spring.task1.Sharay.repository.MysqlBookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

  @Bean
  public BookRepository mysqlBookRepository() {
    return new MysqlBookRepository();
  }

  @Bean
  public BookRepository inMemoryBookRepository() {
    return new InMemoryBookRepository();
  }

  @Bean
  public BookService bookService() {
    return new BookService(mysqlBookRepository());
  }
  @Bean
  public BookService bookService1() {
    return new BookService(inMemoryBookRepository());
  }
}

