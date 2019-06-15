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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        Book result = new Book();
        result.setPublishedIn(2019L);
        result.setAuthor(new Author());
        Map<String, Object> model = new HashMap<>();
        model.put("book", result);
        model.put("authors", bookService.findAuthorsAll());

        return new ModelAndView("book-form", model);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long id) {
        Book result = bookService.findBookById(id).orElseGet(Book::new);
        Map<String, Object> model = new HashMap<>();
        model.put("book", result);
        model.put("authors", bookService.findAuthorsAll());

        return new ModelAndView("book-form", model);
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
    // delete
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView form2() {
        Book result = new Book();
        result.getId();
        return new ModelAndView("bookdel-form", "book", result);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute("delete") Book book, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                LOGGER.error(error.toString());
            }
            model.addAttribute("errorMessage", "something wrong");
        }
        bookService.delete(book.getId());
        return "redirect:list";
    }
    // find
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ModelAndView find() {
        Book result = new Book();
        result.getName();
        return new ModelAndView("book-find", "book", result);
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String find(@ModelAttribute("find") Book book, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                LOGGER.error(error.toString());
            }
            model.addAttribute("errorMessage", "something wrong");
        }
        bookService.findBook(book.getName());
        return "redirect:boook";
    }
       @RequestMapping(value = "/boook", method = RequestMethod.GET)
    public ModelAndView boook() {
           Book result = new Book();
           result.getName();
           List<Book> booksAll = bookService.findBook(result.getName());
//    return new ModelAndView("books", "booksVariable", booksAll);
        Map<String, Object> model = new HashMap<>();
        model.put("booksVariable", booksAll);
        return new ModelAndView("book", model);
    }

}