package by.cources.spring.task6.contoller;

import by.cources.spring.task6.model.Book;
import by.cources.spring.task6.service.AuthorService;
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
public class BookController
{
  public static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
  
  private final BookService bookService;
  
  private final AuthorService authorService;
  

  public BookController(BookService bookService, AuthorService authorService) {
    this.bookService = bookService;
    this.authorService = authorService;
  }

  @RequestMapping(value = "/edit/{mode}/{id}", method = RequestMethod.GET)
  public ModelAndView formInsert(@PathVariable("mode") String mode, @PathVariable("id") Long id) 
  {    
	  ModelAndView modelAndView = new ModelAndView("book-form");
	  modelAndView.addObject("mode", mode);
	  modelAndView.addObject("book", bookService.getForm(mode, id));
	  modelAndView.addObject("authors", authorService.findAuthorsAll()); 
	  return modelAndView;
  }  
  
  @RequestMapping(value = "/edit/{mode}", method = RequestMethod.POST)
  public ModelAndView submit(@PathVariable("mode") String mode,
		  @ModelAttribute("edit") Book book, BindingResult result, ModelMap model) 
  {   	  
	  ModelAndView modelAndView = new ModelAndView("redirect:/");
	  try {
		  if (result.hasErrors())		  
		      throw new Exception(result.getAllErrors().toString());
		  
		  bookService.saveBook(mode, book);
	  } 
	  catch (Exception ex)
	  {
		  modelAndView = new ModelAndView("book-form"); 
		  modelAndView.addObject("errorMessage", ex.getMessage());
		  modelAndView.addObject("book", book);
		  modelAndView.addObject("authors", authorService.findAuthorsAll()); 
		  modelAndView.addObject("mode", mode);       
	  }
	  return modelAndView;
  }  
  
}