package by.cources.spring.task6.contoller;

import by.cources.spring.task6.model.Book;
import by.cources.spring.task6.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

  @RequestMapping(value = "/edit/{mode}/{id}", method = RequestMethod.GET)
  public ModelAndView formInsert(@PathVariable("mode") String mode, @PathVariable("id") Long id) 
  {    
	  ModelAndView modelAndView = new ModelAndView("book-form");
	  modelAndView.addObject("mode", mode);
	  modelAndView.addObject("book", bookService.getForm(mode, id));
	  return modelAndView;
  }  
  
  @RequestMapping(value = "/edit/{mode}", method = RequestMethod.POST)
  public ModelAndView submit(@PathVariable("mode") String mode,
		  @ModelAttribute("edit") Book book, BindingResult result, ModelMap model) 
  {   
	  ModelAndView modelAndView = new ModelAndView("redirect:/");
    try {
    	bookService.saveBook(mode, book, result);
    } 
    catch (Exception ex)
    {
    	modelAndView = new ModelAndView("book-form"); 
    	modelAndView.addObject("errorMessage", ex.getMessage());
    	modelAndView.addObject("mode", mode);       
    }
    return modelAndView;
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ModelAndView list() {
    return new ModelAndView("books", "books", bookService.findBooksAll());
  }
}