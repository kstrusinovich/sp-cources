package by.cources.spring.task6.contoller;

import by.cources.spring.task6.model.Author;
import by.cources.spring.task6.model.Book;
import by.cources.spring.task6.service.BookService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

  //загрузка формы со списком книг
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ModelAndView list() {
    System.out.println(" public ModelAndView list() :: ");
    List<Book> booksAll = bookService.findBooksAll();
//    return new ModelAndView("books", "booksVariable", booksAll);
    Map<String, Object> model = new HashMap<>();
    model.put("booksVariable", booksAll);
    return new ModelAndView("books", model);
  }

  //загрузка формы с книгой для просмотра
  @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
  public ModelAndView edit(@PathVariable Long id) {
    System.out.println(" public ModelAndView edit(@PathVariable Long id) :: ");
    Book result = bookService.findBookById(id).orElseGet(Book::new);
    Map<String, Object> model = new HashMap<>();
    model.put("book", result);
    model.put("authors", bookService.findAuthorsAll());

    return new ModelAndView("book-form", model);
  }

  //загрузка формы с редактируемой книгой
  @RequestMapping(value = "/editBook/{id}", method = RequestMethod.GET)
  public ModelAndView formEdit(@PathVariable Long id) {
    System.out.println("  public ModelAndView formEdit(@PathVariable Long id) :: ");
    Book result = bookService.findBookById(id).orElseGet(Book::new);
    Map<String, Object> model = new HashMap<>();
    model.put("book", result);
    model.put("authors", bookService.findAuthorsAll());

    return new ModelAndView("book-edit", model);
  }

  //запись редактируемой книги и переход на список книг
  @RequestMapping(value = "/editBook", method = RequestMethod.POST)
  public String submitBook(@Valid @ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
    System.out.println(" public String submit(@Valid @ModelAttribute(\"book\") Book book, BindingResult result, ModelMap model) :: ");
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        LOGGER.error(error.toString());
      }
      model.addAttribute("errorMessage", "something wrong (WTF)");
      return "book-edit";
    }
    @Valid Author author = book.getAuthor();
    Long idAuthor = author.getId();
    System.out.println(" idAuthor = " + idAuthor);
    if(idAuthor != null){
      Author authors = bookService.findAuthorById(idAuthor);
      if (authors != null) {
        book.setAuthor(authors);
      }
    }
    bookService.saveBook(book);
    return "redirect:list";
  }

  //удаляем книгу и возвращаемся к списку книг
  @GetMapping(value = "/delete/{id}")
  public String delete(@PathVariable("id") Long id) {
    System.out.println(" public String delete(@PathVariable(\"id\") Long id) :: ");
    bookService.delBook(id);
    return "redirect:/book/list";
  }

  //загрузка формы с редактируемым автором книги
  @RequestMapping(value = "/editAuthor/{id}", method = RequestMethod.GET)
  public ModelAndView formEditAuthor(@PathVariable Long id) {
    System.out.println("  public ModelAndView formEditAuthor(@PathVariable Long id) :: ");
    Book result = bookService.findBookById(id).orElseGet(Book::new);
    Map<String, Object> model = new HashMap<>();
    model.put("book", result);
    model.put("authors", bookService.findAuthorsAll());

    return new ModelAndView("author-edit", model);
  }

  //запись редактируемого автора книги и переход на список книг
  @RequestMapping(value = "/editAuthor", method = RequestMethod.POST)
  public String submitAuthorBook(@Valid @ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
    System.out.println(" public String submit(@Valid @ModelAttribute(\"book\") Book book, BindingResult result, ModelMap model) :: ");
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        LOGGER.error(error.toString());
      }
      model.addAttribute("errorMessage", "something wrong (WTF)");
      return "author-edit";
    }
    @Valid Author author = book.getAuthor();
    Long idAuthor = author.getId();
    System.out.println(" idAuthor = " + idAuthor);
    if(idAuthor != null){
      Author authorById = bookService.findAuthorById(idAuthor);
      if (authorById != null) {
        book.setAuthor(authorById);
      }
    }
    bookService.saveBook(book);
    return "redirect:list";
  }

 /* @RequestMapping(value = "/add", method = RequestMethod.GET)
  public ModelAndView add() {
    Book result = new Book();
    result.setPublishedIn(2019L);
    result.setAuthor(new Author());
    Map<String, Object> model = new HashMap<>();
    model.put("book", result);
    model.put("authors", bookService.findAuthorsAll());

    return new ModelAndView("book-form", model);
  }*/

 /* @RequestMapping(value = "/list", method = RequestMethod.POST)
  public String button(@ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        LOGGER.error(error.toString());
      }
      model.addAttribute("errorMessage", "something wrong");
//      return "error";
      return "books";
    }
    //bookService.saveBook(book);
    return "redirect:editBook";
  }*/


}