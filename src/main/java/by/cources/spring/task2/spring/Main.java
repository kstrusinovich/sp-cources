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
    ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);  //регистрируем класс конфигурации со всеми Bean-ами
    BookRepository service = ctx.getBean(BookRepository.class);
    AuthorRepository serviceAuthor = ctx.getBean(AuthorRepository.class);

    System.out.println("=======================================================");
    List<Book> all = service.findAll();
    for (Book book : all) {
      System.out.println("All books " + book);
    }
    long id = 4L;
    System.out.println("Book with id = " + id + " is " + service.findById(id));
    System.out.println("=======================================================");

    List<Author> allAuthor = serviceAuthor.findAll();
    for (Author author : allAuthor) {
      System.out.println("All author " + author);
    }
    int idAuthor = 2;
    System.out.println("Author with id = " + idAuthor + " is " + serviceAuthor.findById(idAuthor));
    System.out.println("=======================================================");

    List<Author> allAuthorsWithBookOlder = serviceAuthor.findAuthorsWithBookOlder(1810L);
    for (Author authors : allAuthorsWithBookOlder) {
      System.out.println("All authors :: " + authors);
    }
  }
}
