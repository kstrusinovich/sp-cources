package by.cources.spring.task4.spring;

import by.cources.spring.task4.spring.model.Author;
import by.cources.spring.task4.spring.model.Book;
import by.cources.spring.task4.spring.model.Language;
import by.cources.spring.task4.spring.service.BookService;
import by.cources.spring.util.TextUtil;

import java.time.LocalDate;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main 
{

	
  public static void main(String[] args) 
  {
	  //
	  @SuppressWarnings("resource")
	  ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
	  BookService service = ctx.getBean(BookService.class);
    
	  //
	  //
	  //
	  
	  System.out.println("* Save authors:");    
	  Author author1 = service.saveAuthor("Hemingway", "Ernest", LocalDate.of(1961, 7, 2) );
	  Author author2 = service.saveAuthor("Remarque", "Erich Maria", LocalDate.of(1898, 6, 22) );
	  
	  System.out.println("* Save books and languages with doubles:");
	  service.saveBookAndLanguage(author1, "A Farewell To Arms", 1929L, "english", true);
	  service.saveBookAndLanguage(author1, "For Whom The Bell Tolls", 1940L, "english", true);	  
	  
	  System.out.println("* Save books and languages without doubles:");
	  service.saveBookAndLanguage(author2, "Im Westen nichts Neues", 1929L, "deutsch", false);
	  service.saveBookAndLanguage(author2, "Drei Kameraden", 1936L, "deutsch", false);  
	  service.saveBookAndLanguage(author2, "Arc de Triomphe", 1945L, "deutsch", false);
    	  
	  //
	  //
	  //
	  
	  System.out.println("\nAUTHORS");
	  List <Author> authorList = service.findAuthorsAll();
	  TextUtil.viewList(authorList, false);
    
	  System.out.println("\nBOOKS");
	  List <Book> bookList = service.findBooksAll();
	  TextUtil.viewList(bookList, false);

	  System.out.println("\nLANGUAGES");
	  List<Language> languageList = service.findLanguagesAll();
	  TextUtil.viewList(languageList, false);
	  
  }
   
}