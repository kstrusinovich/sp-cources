package by.cources.spring.task4.spring;

import by.cources.spring.task4.spring.model.Author;
import by.cources.spring.task4.spring.model.Book;
import by.cources.spring.task4.spring.service.BookService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Task4Main {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
    BookService service = ctx.getBean(BookService.class);
    System.out.println("---------------------");
    Author author = new Author();
    author.setLastName("lastName");
    author.setFirstName("firstName");
    author.setDateOfBirth(LocalDate.now());
    service.saveAuthor(author);
    Author author1 = new Author();
    author1.setLastName("lastName1");
    author1.setFirstName("firstName1");
    author1.setDateOfBirth(LocalDate.now());
    service.saveAuthor(author1);

    System.out.println("Saved author with id = " + author.getId());
    System.out.println("---------------------");
    query5(service);
    System.out.println("=======================================");
    Book book = new Book();
    //book.setId("id");
    book.setAuthor(author);
    book.setName("name");
    book.setPublishedIn(1833L);
    System.out.println("1======================================");
    service.saveBook(book);
    System.out.println("2======================================");
    service.saveBook(book);
    System.out.println("3======================================");
    service.saveBook(book);
    System.out.println("4======================================");
    service.saveBook(book);
    query6(service);
  }

  private static void query5(BookService service) {
    List<Author> authors = service.findAuthorsAll();
    for (Author author : authors) {
      System.out.println("Query5: " + author);
    }
  }

  private static void query6(BookService service) {
    System.out.println("=======================================");
    List<Book> books = service.findBooksAll();
    for (Book book : books) {
      System.out.println("Query6: " + book);
    }
  }
}
