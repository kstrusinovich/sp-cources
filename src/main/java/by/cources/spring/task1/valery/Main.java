package by.cources.spring.task1.valery;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
		BookService service = ctx.getBean("bookService1", BookService.class);
		List<Book> all = service.findAll();
		for (Book book : all) {
			System.out.println(book);
		}
	}
}
