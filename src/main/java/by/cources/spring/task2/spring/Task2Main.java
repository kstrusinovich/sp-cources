package by.cources.spring.task2.spring;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.service.FindService;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
	/**  **/
	private static final long TEST_BOOK_ID = 4;
	
	/**  **/
	private static final long TEST_AUTHOR_ID = 1;
	
	/**  **/
	private static final long TEST_YEAR = 1970;
	
	
	public static void main(String[] args) 
	{
		//
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);    
		FindService findService = ctx.getBean(FindService.class);
      
		//    
		System.out.println("BOOKS");
		List <Book> bookList = findService.findAllBooks();
		findService.viewBooks(bookList);				
		    
		//
		System.out.println("\nAUTHORS");
		List <Author> authorList = findService.findAllAuthors();
		findService.viewAuthors(authorList);
		
		System.out.println("");
		findService.findBookById(TEST_BOOK_ID);
		findService.findAuthorById(TEST_AUTHOR_ID);
		findService.findAuthorsWithBooksAfterYear(TEST_YEAR);
				
    
	}
  
}