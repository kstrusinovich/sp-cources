package by.cources.spring.task6.contoller;

import by.cources.spring.task6.model.Author;
import by.cources.spring.task6.model.Book;
import by.cources.spring.task6.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book")
public class BookController {
  public  long id;
  public static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @RequestMapping(value = "/edit", method = RequestMethod.GET)
  public ModelAndView form() {
    Book result = new Book();
    result.setAuthor(new Author());
    return new ModelAndView("book-form", "book", result);
  }

 @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public String submit(@ModelAttribute("edit") Book book, BindingResult result, ModelMap model) {
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
       LOGGER.error(error.toString());
    }
      model.addAttribute("errorMessage", "something wrong");
//   return "error";
    return "books";
  }
   bookService.saveBook(book);
  return "redirect:list";
 }
  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public ModelAndView form2() {
   Book result = new Book();
    result.getId();
    return new ModelAndView("book-formdelete", "book",result);
  }
  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  public String delete (@ModelAttribute("delete") Book book, BindingResult result, ModelMap model) {
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        LOGGER.error(error.toString());
      }
      model.addAttribute("errorMessage", "something wrong");
//   return "error";
//      return "books";
    }
    bookService.delete(book.getId());
    return "redirect:list";
  }
    @RequestMapping(value = "/redit", method = RequestMethod.GET)
    public ModelAndView form3() {
        Book result = new Book();
        result.getId();
        return new ModelAndView("book-formredit", "book", result);
    }
    @RequestMapping(value = "/redit", method = RequestMethod.POST)
    public ModelAndView redit (@ModelAttribute("redit") Book book, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                LOGGER.error(error.toString());
            }
            model.addAttribute("errorMessage", "something wrong");
//   return "error";
//      return "books";
        }
        bookService.edit(book.getId());
        //return "redirect:list";
        return new ModelAndView("book-form", "book", result);
    }

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ModelAndView list() {
    return new ModelAndView("books", "books", bookService.findBooksAll());
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET)
   public ModelAndView list2() {
        return new ModelAndView("books", "books", bookService.edit(id));
    }

}
