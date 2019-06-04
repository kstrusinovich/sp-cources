package by.cources.spring.task3.spring;

import by.cources.spring.task3.spring.model.Author;
import by.cources.spring.task3.spring.model.Book;
import by.cources.spring.task3.spring.model.Language;
import by.cources.spring.task3.spring.service.SearchService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	private static final String BOOK_LANGUAGE= "english";
	private static final String BOOK_NAME= "Le Capitaine Paul";
	private static final Long PUBLISHED_DATE= 1818L;

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
    SearchService service = ctx.getBean(SearchService.class);
    System.out.println("---------------------");
    query1(service);
    System.out.println("---------------------");
    query2(service);
    System.out.println("---------------------");
    query3(service);
    System.out.println("---------------------");
    query4(service);
    System.out.println("---------------------");
    query5(service);
    System.out.println("---------------------");
    query6(service);
    System.out.println("---------------------");
    query7(service);
    System.out.println("---------------------");
    query8(service);
  }

  private static void query1(SearchService service) {
    List<Book> all = service.findBooksAll();
    for (Book book : all) {
      System.out.println("Query1: " + book);
    }
  }

  private static void query2(SearchService service) {
    List<Book> all = service.findBooksWithBookOlderThan(PUBLISHED_DATE);
    for (Book book : all) {
      System.out.println("Query2: " + book);
    }
  }

  private static void query3(SearchService service) {
    List<Author> authors = service.findAuthorsWithBookOlderThan(PUBLISHED_DATE);
    for (Author author : authors) {
      System.out.println("Query3: " + author);
    }
  }

  private static void query4(SearchService service) {
    List<Book> books = service.findBooksWithBookName(BOOK_NAME);
    for (Book book : books) {
      System.out.println("Query4: " + book);
    }
  }

  private static void query5(SearchService service) {
    List<Author> authors = service.findAuthorsAll();
    for (Author author : authors) {
      System.out.println("Query5: " + author);
    }
  }
  
  private static void query6(SearchService service) {
	    List<Language> all = service.findLanguagesAll();
	    for (Language language : all) {
	      System.out.println("Query6: all languages: " + language);
	    }
	  }
  
  private static void query7(SearchService service) {
	    List<Book> all = service.findBooksByLanguage(BOOK_LANGUAGE);
	    for (Book book : all) {
	      System.out.println("Query7: in " + BOOK_LANGUAGE + " " + book);
	    }
	  }
  
  private static void query8(SearchService service) {
	    List<Author> all = service.findAuthorsByLanguage(BOOK_LANGUAGE);
	    for (Author author : all) {
	      System.out.println("Query8: in " + BOOK_LANGUAGE + " " + author);
	    }
	  }
}
