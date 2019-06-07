package by.cources.spring.task5.spring.contoller;

import by.cources.spring.task5.spring.model.Language;
import by.cources.spring.task5.spring.service.BookService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lang")
public class LanguageController {

	private final BookService bookService;

	public LanguageController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping(value = "/all")
	@ResponseBody
	public List<Language> all() {
		return bookService.findLangAll();
	}
}