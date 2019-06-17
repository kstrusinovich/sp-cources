package by.cources.spring.task6.contoller;

import by.cources.spring.task6.model.Author;
import by.cources.spring.task6.model.Book;
import by.cources.spring.task6.service.BookService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

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
    Map<String, Object> model = new HashMap<>();
    model.put("book", result);
    model.put("authors", bookService.findAuthorsAll());

    return new ModelAndView("book-form", model);
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
  public String submit(@Valid @ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        LOGGER.error(error.toString());
      }
      model.addAttribute("errorMessage", "something wrong");
//      return "error";
      return "book-form";
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
  @RequestMapping(value = "/find", method = RequestMethod.GET)
  public ModelAndView formFind() {
    Book result = new Book();
    return new ModelAndView("book-find", "book", result);
  }
  @RequestMapping(value = "/find", method = RequestMethod.POST)
  public ModelAndView find(@ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
    Optional<Book> book1 = bookService.findBookById(book.getId());
    if (book1.isPresent()) {
      return new ModelAndView("book-form", "book", book1.get());
    } else {
      ModelAndView errorModel = new ModelAndView("error");
      errorModel.addObject("errorMessage", "BOOK NOT FOUND");
      return errorModel;

    }
  }
  /*@RequestMapping(value = "/find", method = RequestMethod.POST)
  public String find(@ModelAttribute("book") Book book, BindingResult result, ModelMap model){
        if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        LOGGER.error(error.toString());
      }
      model.addAttribute("errorMessage", "something wrong");
//      return "error";
      return "book-find";
    }
    bookService.findBookById(book.getId());
   // return "redirect:book/edit/{"+book.getId()+"}";
    return "redirect:list";
  }*/

  @GetMapping(value = "/delete/{id}")
  public String delete(@PathVariable("id") Long id) {
System.out.println("id="+id);
    bookService.deleteBook(id);
    return "redirect:/book/list";
  }


  @RequestMapping(value = "/editA", method = RequestMethod.GET)
  public ModelAndView formAut() {

    List<Author> authorsAll = bookService.findAuthorsAll();
    List<Book> booksAll = bookService.findBooksAll();
    Map<String, Object> model = new HashMap<>();

    model.put("authors", authorsAll);
    model.put("bookVar",booksAll);

    return new ModelAndView("book-form-author", model);
  }

}