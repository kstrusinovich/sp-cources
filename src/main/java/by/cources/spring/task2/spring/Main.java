package by.cources.spring.task2.spring;

import by.cources.spring.task2.spring.model.Book;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
		BookService service = ctx.getBean("bookService", BookService.class);
		List<Book> all = service.findAll();
		for (Book book : all) {
			System.out.println("All books " + book);
		}

		Long id = 4L;
		System.out.println("Book with id = " + id + " is " + service.findById(id));
	}
}
