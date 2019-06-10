package by.cources.spring.task6.contoller;

import by.cources.spring.task6.model.Author;
import by.cources.spring.task6.model.Book;
import by.cources.spring.task6.service.BookService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book")
public class BookController {

	public static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView form() {
		Book result = new Book();
		result.setPublishedIn(2019L);
		result.setAuthor(new Author());
		return new ModelAndView("book-form", "book", result);
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") Long id) {
		Optional<Book> book = bookService.findBookById(id);
		if (book.isPresent()) {
			return new ModelAndView("book-form", "book", book.get());
		}

		ModelAndView errorModel = new ModelAndView("error");
		errorModel.addObject("errorMessage", "BOOK NOT FOUND");
		return errorModel;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String submit(@ModelAttribute("edit") Book book, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				LOGGER.error(error.toString());
			}
			model.addAttribute("errorMessage", "something wrong");
//      return "error";
			return "books";
		}
		bookService.saveBook(book);
		return "redirect:list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		List<Book> booksAll = bookService.findBooksAll();
//    return new ModelAndView("books", "booksVariable", booksAll);
		Map<String, Object> model = new HashMap<>();
		model.put("booksVariable", booksAll);
		return new ModelAndView("books", model);
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		bookService.delBook(id);
		return "redirect:/book/list";
	}
	
	@RequestMapping(value = "/editAuthor/{id}", method = RequestMethod.GET)
	public ModelAndView editAuthor(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView("book-form-author");
		Optional<Book> book = bookService.findBookById(id);
		if (book.isPresent()) {
			model.addObject("book", book.get());
			
			model.addObject("authors", bookService.findAuthorsAll());
			return model;
		} else {
			ModelAndView errorModel = new ModelAndView("error");
			errorModel.addObject("errorMessage", "BOOK NOT FOUND");
			return errorModel;
		}
	}
}
