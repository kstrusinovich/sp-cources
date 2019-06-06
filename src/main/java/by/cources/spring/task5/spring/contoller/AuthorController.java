package by.cources.spring.task5.spring.contoller;

import by.cources.spring.task5.spring.model.Author;
import by.cources.spring.task5.spring.service.BookService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

	private final BookService bookService;

	public AuthorController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping(value = "/all")
	@ResponseBody
	public List<Author> all() {
		return bookService.findAuthorsAll();
	}
	
	@GetMapping(value = "/bookOlderThan/{year}")
	@ResponseBody
	public List<Author> bookOlderThan(@PathVariable("year") Long year) {
		return bookService.findAuthorsWithBookOlderThan(year);
	}
}