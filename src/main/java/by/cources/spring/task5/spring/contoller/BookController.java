package by.cources.spring.task5.spring.contoller;

import by.cources.spring.task5.spring.model.Author;
import by.cources.spring.task5.spring.model.Book;
import by.cources.spring.task5.spring.model.Language;
import by.cources.spring.task5.spring.service.BookService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping(value = "/sample1", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Author>> sample1(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return new ResponseEntity<>(bookService.findAuthorsAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/sample2/{year}")
	@ResponseBody
	public List<Book> sample2(@PathVariable("year") Long year) {
		return bookService.findBooksWithBookOlderThan(year);
	}

	@GetMapping(value = "/sample3")
	@ResponseBody
	public List<Book> sample3(@RequestParam String name) {
		return bookService.findBooksWithBookName(name);
	}

	@PostMapping(value = "/sample4")
	@ResponseBody
	public Book sample4(@RequestBody Book book) {
		book.setName("*" + book.getName());
		return book;
	}

	@GetMapping(value = "/all")
	@ResponseBody
	public List<Book> all() {
		return bookService.findBooksAll();
	}

	@GetMapping(value = "/olderThan")
	@ResponseBody
	public List<Book> all(@RequestParam Long year) {
		return bookService.findBooksWithBookOlderThan(year);
	}

	/*
	 * {"name": "Sense and Sensibility11","publishedIn": 1811}
	 * 
	 * http://localhost:8080/myapp/book/add/RU/1
	 */
	@PostMapping(value = "/add/{lang}/{authorId}")
	@ResponseBody
	public List<Book> add(@RequestBody Book book, @PathVariable("lang") String lang,
			@PathVariable("authorId") Long authorId) {
		Author author = bookService.findAuthorById(authorId).get();
		book.setAuthor(author);
		Language language = new Language();
		language.setName(lang);
		book.setLanguage(language);
		System.out.println("book = " + book);
		bookService.saveBook(book);
		return bookService.findBooksAll();
	}

	/*
	 * { "name":"Sense and Sensibility11", "publishedIn":1811, "author":{
	 * "firstName":"Valery", "lastName":"Konchevich", "dateOfBirth":"1775-12-16" },
	 * "language":{ "name":"FR" } }
	 * 
	 * http://localhost:8080/myapp/book/addFull
	 */
	@PostMapping(value = "/addFull")
	@ResponseBody
	public List<Book> add(@RequestBody Book book) {
		List<Language> langs = bookService.findLangByName(book.getLanguage().getName());
		if (!langs.isEmpty()) {
			book.setLanguage(langs.get(0));
		}
		Author author = book.getAuthor();
		List<Author> authors = bookService.findAuthorByName(author.getFirstName(), author.getLastName());
		if (!authors.isEmpty()) {
			book.setAuthor(authors.get(0));
		}
		bookService.saveBook(book);
		return bookService.findBooksAll();
	}

	@DeleteMapping(value = "/delete/{id}")
	@ResponseBody
	public List<Book> delete(@PathVariable("id") Long id) {
		//bookService.findBookById(id).ifPresent(book -> bookService.delBook(book));
		bookService.findBookById(id).ifPresent(bookService::delBook);
		return bookService.findBooksAll();
	}
}