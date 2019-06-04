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
    ApplicationContext ctxSeconde = new AnnotationConfigApplicationContext(AuthorConfig.class);
    BookRepository service = ctx.getBean(BookRepository.class);
    AuthorRepository serviceAuthor = ctxSeconde.getBean(AuthorRepository.class);

    System.out.println("=======================================================");
    List<Book> all = service.findAll();
    for (Book book : all) {
      System.out.println("All books " + book);
    }
    long id = 4L;
    System.out.println("Book with id = " + id + " is " + service.findById(id));

    System.out.println("=======================================================");
    List<Author> allAuthor = serviceAuthor.findAll();
    for(Author author : allAuthor)
    {
      System.out.println("All author : " + author);
    }
    int idAuthor = 2;
    System.out.println("Book with id = " + idAuthor + " is " + serviceAuthor.findById(idAuthor));

    System.out.println("=======================================================");
    List<Author> allAuthors = serviceAuthor.findAuthorsWithBookOlder(1830L);
    for(Author authors : allAuthors)
    {
      System.out.println("All authors : " + authors);
    }

    System.out.println("TEST PUSH");
  }
}
