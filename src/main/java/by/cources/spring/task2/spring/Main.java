package by.cources.spring.task2.spring;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.repository.BookRepository;
import by.cources.spring.task2.spring.repository.AuthorRepository;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
    BookRepository service = ctx.getBean(BookRepository.class);
    AuthorRepository serviceAuthor = ctx.getBean(AuthorRepository.class);

    List<Book> all = service.findAll();
    for (Book book : all) {
      System.out.println("All books " + book);
    }
    long id = 4L;
    System.out.println("Book with id = " + id + " is " + service.findById(id));

    List<Author> allAuthor = serviceAuthor.findAll();
  }
}
