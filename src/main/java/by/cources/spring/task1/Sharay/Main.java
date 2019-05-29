package by.cources.spring.task1.Sharay;

import by.cources.spring.task1.Sharay.Book;
import by.cources.spring.task1.Sharay.BookConfig;
import by.cources.spring.task1.Sharay.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
    BookService service = ctx.getBean("bookService",BookService.class);
    List<Book> all = service.findAll();
    for (Book book : all) {
      System.out.println(book);
    }
  }
}
