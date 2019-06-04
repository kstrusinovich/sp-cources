package by.cources.spring.task2.spring;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.model.Book;
import java.util.List;

import by.cources.spring.task2.spring.service.BookAuthorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
    BookAuthorService bookAuthorService = ctx.getBean(BookAuthorService.class);

    System.out.println("=======================================================");
    query1(bookAuthorService);
    System.out.println("=======================================================");
    query2(bookAuthorService);
    System.out.println("=======================================================");
    query3(bookAuthorService);
    System.out.println("=======================================================");
    query4(bookAuthorService);
    System.out.println("=======================================================");
    query5(bookAuthorService);
  }
  private static void query1(BookAuthorService bookAuthorService){
    List<Book> allBook = bookAuthorService.findAllBooks();
    for (Book book : allBook) {
      System.out.println("All books " + book);
    }
  }

  private static void query2(BookAuthorService bookAuthorService){
    long id = 4L;
    System.out.println("Book with id = " + id + " is " + bookAuthorService.findBookById(id));
  }

  private static void query3(BookAuthorService bookAuthorService){
    List<Author> allAuthors = bookAuthorService.findAllAuthors();
    for(Author author : allAuthors) {
      System.out.println("All author : " + author);
    }
  }

  private static void query4(BookAuthorService bookAuthorService){
    int idAuthor = 2;
    System.out.println("Book with id = " + idAuthor + " is " + bookAuthorService.findAuthorById(idAuthor));
  }

  private static void query5(BookAuthorService bookAuthorService){
    List<Author> authorsWithBookOlder = bookAuthorService.findAuthorsWithBookOlder(1830L);
    for(Author author : authorsWithBookOlder) {
      System.out.println(" author : " + author);
    }
  }
}
