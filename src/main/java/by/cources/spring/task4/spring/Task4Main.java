package by.cources.spring.task4.spring;

import by.cources.spring.task4.spring.model.Book;
import by.cources.spring.task4.spring.model.Author;
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
    query5(service);

    System.out.println("---------------------");
    Book book = new Book();
    book.setPublishedIn(1970L);
    book.setName("Challenger");
    service.saveBook(book);
    System.out.println("Query6" + book);
    System.out.println("---------------------");

    book.setPublishedIn(1835L);
    book.setName("gold fish");
    service.saveBook(book);
    Language language = new Language();
    language.setName("Russian");
    service.saveLanguage(language);
    System.out.println("QueryBook6" + book);
    System.out.println("QueryLanguage6" + language);




    book.setPublishedIn(1835L);
    book.setName("gold fish1");
    service.saveBook(book);

    language.setName("Russian1");
    service.saveLanguage(language);
    System.out.println("QueryBook61" + book);
    System.out.println("QueryLanguage61" + language);
  }

  private static void query5(BookService service) {
    List<Author> authors = service.findAuthorsAll();
    for (Author author : authors) {
      System.out.println("Query5: " + author);
    }
  }


}
