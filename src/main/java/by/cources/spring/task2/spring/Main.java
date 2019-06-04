package by.cources.spring.task2.spring;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.repository.AuthorRepository;
import by.cources.spring.task2.spring.repository.BookRepository;
import java.util.List;

//import by.cources.spring.task2.spring.repository.JdbcTemplateAuthorRepository;
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
    ApplicationContext ctx2 = new AnnotationConfigApplicationContext(AuthorConfig.class);
    AuthorRepository services = ctx2.getBean(AuthorRepository.class);
    List<Author> alls = services.findAll();

    for (Author author: alls) {
      System.out.println("All Authors " + author);
    }
    long ids = 3L;
    System.out.println("Author with id = " + ids + " is " + services.findById(id));

    ApplicationContext ctx3 = new AnnotationConfigApplicationContext(BookConfig.class);
    BookRepository service1 = ctx3.getBean(BookRepository.class);
    long year = 1965L;
    List<Book> years = service1.findByyear(year);
     //for (Book book: years) {
       System.out.println("Book with Year > " + year) ;
       System.out.println(" is" + service1.findByyear(year));

    ApplicationContext ctx5 = new AnnotationConfigApplicationContext(AuthorConfig.class);
    AuthorRepository service2 = ctx5.getBean(AuthorRepository.class);
    List<Author> yeart = service2.findByyear(year);
    System.out.println("Author with Year > " + year) ;
    System.out.println(" is" + service2.findByyear(year));

     //}
   // ApplicationContext ctx3 = new AnnotationConfigApplicationContext(AuthorConfig.class);
    //AuthorRepository services1 = ctx3.getBean(AuthorRepository.class);
   // List<Author> year = services1.findByyear(year);
  }
}
