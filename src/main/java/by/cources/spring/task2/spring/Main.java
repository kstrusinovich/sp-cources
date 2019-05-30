package by.cources.spring.task2.spring;

import by.cources.spring.task2.spring.model.Autor;
import by.cources.spring.task2.spring.model.Book;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
		BookService service = ctx.getBean("bookService", BookService.class);

		System.out.println("\n***** A L L   B O O K S   L I S T *****");
		List<Book> books = service.findAll(); // ищем все книги
		for (Book book : books) {
			System.out.println("bookId = " + book.getId() + " is " + book);
		}
		System.out.println("******************************");

		System.out.println("\n***** F I N D   B O O K *****");
		Book book = service.findById(4L);
		System.out.println("bookId = " + book.getId() + " is " + book);
		System.out.println("\n******************************");

		System.out.println("\n***** F I N D   A U T O R S *****");
		List<Autor> autors = service.findAutorByWhere("id IN (SELECT autor FROM book WHERE year>1965)"); // ищем авторов
		for (Autor autor : autors) {
			books = service.findAll("autor=" + autor.getId()); // ищем книги автора
			System.out.println("autorId = " + autor.getId() + " is " + autor);
			for (Book book1 : books) {
				System.out.println("bookId = " + book.getId() + " is " + book);
			}
			System.out.println("\n");
		}
		System.out.println("\n******************************");
	}
}
