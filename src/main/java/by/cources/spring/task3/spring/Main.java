package by.cources.spring.task3.spring;

import by.cources.spring.task3.spring.model.Author;
import by.cources.spring.task3.spring.model.Book;
import by.cources.spring.task3.spring.model.Language;
import by.cources.spring.task3.spring.service.FindService;
import by.cources.spring.util.TextUtil;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main 
{	
	private static final Long TEST_YEAR = 1818L;
	
	private static final String TEST_BOOK_NAME = "Le Capitaine Paul";

	private static final String TEST_LANGUAGE_NAME = "russian";
	
	
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
		FindService service = ctx.getBean(FindService.class);
    						
		//
		System.out.println("AUTHORS");
		List <Author> authors = service.findAuthorsAll();
		TextUtil.viewList(authors, false);
		
		//
		System.out.println("\nLANGUAGES");
		List <Language> languages = service.findLanguageAll();
		TextUtil.viewList(languages, false);
		
		//
		System.out.println("\nBOOKS");
		List <Book> all = service.findBooksAll();
		TextUtil.viewList(all, false);
    
		//
		System.out.println("");
		
		//
		System.out.println("* Books published after " + TEST_YEAR + ":");
		all = service.findBooksWithBookOlderThan(TEST_YEAR);
		TextUtil.viewList(all, true);
    
		//
		System.out.println("* Authors with book older than " + TEST_YEAR + ":");
		authors = service.findAuthorsWithBookOlderThan(TEST_YEAR);
		TextUtil.viewList(authors, true);
    
		//
		System.out.println("* Books with book name \"" + TEST_BOOK_NAME + "\":");
		List <Book> books = service.findBooksWithBookName(TEST_BOOK_NAME);
		TextUtil.viewList(books, true);
		
		System.out.println("* Books on language \"" + TEST_LANGUAGE_NAME + "\":");
		books = service.findBooksOnLanguage(TEST_LANGUAGE_NAME);
		TextUtil.viewList(books, true);
		
		System.out.println("* Authors with book on language \"" + TEST_LANGUAGE_NAME + "\":");
		authors = service.findAuthorsWithBookOnLanguage(TEST_LANGUAGE_NAME);
		TextUtil.viewList(authors, true);
		 
		System.out.println("* Authors with books on language \"" + TEST_LANGUAGE_NAME +
				"\" after " + TEST_YEAR +":");
		authors = service.findAuthorsWithBooksOnLanguageAfterYear(TEST_LANGUAGE_NAME, TEST_YEAR);
		TextUtil.viewList(authors, true);
		
  }

  
}
