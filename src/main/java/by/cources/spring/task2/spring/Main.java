package by.cources.spring.task2.spring;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.service.FindService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	
  public static void main(String[] args) 
  {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
    
    FindService findService = ctx.getBean(FindService.class);
      
    System.out.println("BOOKS");
    
    List<Book> all = findService.findAllBooks();
    for (Book book : all) {
      System.out.println("All books " + book);
    }
    long id = 4L;
    System.out.println("Book with id = " + id + " is " + findService.findBookById(id));
    
    System.out.println("\nAUTHORS");
    List<Author> all2 = findService.findAllAuthors();
    for (Author author : all2) {
      System.out.println("All authors " + author);
    }
    id = 1L;
    System.out.println("Book with id = " + id + " is " + findService.findAuthorById(id));
    
  }
}
