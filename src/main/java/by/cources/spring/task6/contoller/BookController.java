package by.cources.spring.task6.contoller;

import by.cources.spring.task6.model.Author;
import by.cources.spring.task6.model.Book;
import by.cources.spring.task6.service.BookService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
<<<<<<<<< Temporary merge branch 1
import org.springframework.web.bind.annotation.RequestAttribute;
=========
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>>>> Temporary merge branch 2
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
<<<<<<<<< Temporary merge branch 1
  public String submit(@ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
=========
  public String submit(@Valid @ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
>>>>>>>>> Temporary merge branch 2
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

  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public ModelAndView delete(@RequestAttribute("id") Long id) {
    ModelAndView modelAndView = new ModelAndView("book-delete");
    modelAndView.addObject("book", bookService.getBookById(id));
    List<Book> booksAll = bookService.findBooksAll();
//    return new ModelAndView("books", "booksVariable", booksAll);
    Map<String, Object> model = new HashMap<>();
    model.put("booksVariable", booksAll);
    return new ModelAndView("book-delete", model);
  }

  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  public ModelAndView submitDelete(@ModelAttribute("book-delete") Book book, BindingResult result, ModelMap model) {
    ModelAndView  modelAndView = new ModelAndView("redirect:book/list");
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        LOGGER.error(error.toString());
      }
      model.addAttribute("errorMessage", "something wrong");
//      return "error";
      return modelAndView;
    }
    bookService.deleteBook(book);
    return modelAndView;
  }
}