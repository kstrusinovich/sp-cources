package by.cources.spring.task2.spring;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.repository.AuthorRepository;
import by.cources.spring.task2.spring.repository.BookRepository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static final int YEAR = 1960;

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		BookRepository bookService = ctx.getBean(BookRepository.class);
		AuthorRepository authorService = ctx.getBean(AuthorRepository.class);

		LocalDate year = LocalDate.of(YEAR, 12, 31);

		System.out.println("\t\t.:::::All Books:::::.");
		List<Book> allBooks = bookService.findAll();
		for (Book book : allBooks) {
			System.out.println(book);
		}

		System.out.println("\n\t\t.:::::All Authors:::::.");
		List<Author> allAuthors = authorService.findAll();
		for (Author book : allAuthors) {
			System.out.println(book);
		}

//    long id = 2L;
//    System.out.println("Book with id = " + id + " is " + bookService.findById(id));

		System.out.println("\n\tAuthors, who was born since " + year.getYear() + " are: ");
		allAuthors = null;
		allAuthors = authorService.findAuthorsWhoWasBornSince(year);
		for (Author authors : allAuthors)
		System.out.println(authors);
	}
}
