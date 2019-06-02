package by.cources.spring.task2.spring;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.repository.AuthorRepository;
import by.cources.spring.task2.spring.repository.BookRepository;
import java.util.List;

import by.cources.spring.task2.spring.repository.JdbcTemplateAuthorRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
    BookRepository service = ctx.getBean(BookRepository.class);
    List<Book> all = service.findAll();
    for (Book book : all) {
      System.out.println("All books " + book);
    }
    long id = 3L;
    System.out.println("Book with id = " + id + " is " + service.findById(id));
    AuthorRepository services = ctx.getBean(AuthorRepository.class);
    List<Author> alls = services.findAll();

    for (Author author: alls) {
      System.out.println("All Authors" + author);
    }
    long ids = 3L;
    System.out.println("Author with id = " + ids + " is " + services.findById(id));
  }
}
