package by.cources.spring.task2.spring;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.repository.AuthorRepository;
import by.cources.spring.task2.spring.repository.BookRepository;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Task2Main {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
    BookRepository service = ctx.getBean(BookRepository.class);

    ApplicationContext ctx1 = new AnnotationConfigApplicationContext(AuthorConfig.class);
    AuthorRepository service1 = ctx1.getBean(AuthorRepository.class);

    List<Book> all = service.findAll();

    List<Author> all1 = service1.findAll();

    Book byId = service.findById(1L);
    for (Book book : all) {
      System.out.println("All books " + book);
    }
    for (Author author : all1){
      System.out.println("All author " + author);
    }
    long id = 4L;
    System.out.println("Book with id = " + id + " is " + service.findById(id));
  }
}
