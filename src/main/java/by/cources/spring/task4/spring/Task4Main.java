package by.cources.spring.task4.spring;

import by.cources.spring.task4.spring.model.Author;
import by.cources.spring.task4.spring.model.Book;
import by.cources.spring.task4.spring.model.Language;
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
    System.out.println("Saved author with id = " + author.getId());
    System.out.println("---------------------");
    
    System.out.println("---------------------");
    Language lang = new Language();
    lang.setName("RU");
    System.out.println("---------------------");

    System.out.println("---------------------");
    Book book = new Book();
    book.setName("bookName");
    book.setAuthor(author);
    book.setPublishedIn(1990L);
    book.setLanguage(lang);
    service.saveBook(book);
    System.out.println("1 Saved book with id = " + book.getId());
    
    lang.setId(null);
    book.setId(null);
    service.saveBook(book);
    System.out.println("2 Saved book with id = " + book.getId());
    
    
    System.out.println("---------------------");

    System.out.println("---------------------- ALL AUTHORS");
    query5(service);
    System.out.println("---------------------- ALL LANGUAGE");
    query6(service);
    System.out.println("---------------------- ALL BOOKS");
    query7(service);
    System.out.println("---------------------");
    
  }

  private static void query5(BookService service) {
    List<Author> authors = service.findAuthorsAll();
    for (Author author : authors) {
      System.out.println("Query5: " + author);
    }
  }

  private static void query6(BookService service) {
    List<Language> languages = service.findLangAll();
    for (Language lang : languages) {
      System.out.println("Query7: " + lang);
    }
  }

  private static void query7(BookService service) {
    List<Book> books = service.findBooksAll();
    for (Book book : books) {
      System.out.println("Query6: " + book);
    }
  }

}
