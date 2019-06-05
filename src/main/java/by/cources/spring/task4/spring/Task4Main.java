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

  public static void main(String[] args) 
  {
    @SuppressWarnings("resource")
	ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
    BookService service = ctx.getBean(BookService.class);
    
    System.out.println("---------------------");
    
    Author author = new Author();
    author.setLastName("lastName");
    author.setFirstName("firstName");
    author.setDateOfBirth(LocalDate.now());
    service.saveAuthor(author);
    System.out.println("Saved author with id = " + author.getId());
    
    //
    Language language = new Language();
    language.setName("belarussian");
    
    Book book = new Book();
    book.setAuthor(author);
    book.setName("Test book");
    book.setPublishedIn(2019L);   
    book.setLanguage(language);
    
    service.saveBook(book);    
    System.out.println("Saved book with id = " + book.getId());
    System.out.println("Saved language with id = " + language.getId());
    
    Book book2 = new Book();
    book2.setAuthor(author);
    book2.setName("Test book 2");
    book2.setPublishedIn(2001L);   
    book2.setLanguage(language);
    
    service.saveBook(book2);
    System.out.println("Saved book with id = " + book2.getId());
    System.out.println("Saved language with id = " + language.getId());
    
    System.out.println("\nAUTHORS");
    query5(service);    

    System.out.println("\nBOOKS");
    query7(service);    

    System.out.println("\nLANGUAGES");
    query6(service);
  }

  private static void query5(BookService service)
  {
    List<Author> authors = service.findAuthorsAll();
    for (Author author : authors) 
    {
      System.out.println("Query5: " + author);
    }
  }
  
  private static void query7(BookService service)
  {
    List<Book> books = service.findBooksAll();
    for (Book book : books) 
    {
      System.out.println("Query7: " + book);
    }
  }
  
  private static void query6(BookService service)
  {
    List<Language> languages = service.findLanguagesAll();
    for (Language language : languages) 
    {
      System.out.println("Query6: " + language);
    }
  }
}
