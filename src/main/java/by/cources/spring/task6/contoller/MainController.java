package by.cources.spring.task6.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.cources.spring.task6.service.AuthorService;
import by.cources.spring.task6.service.BookService;

@Controller
@RequestMapping("/")
public class MainController 
{
  public static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
  
  private final BookService bookService;
  
  private final AuthorService authorService;
  

  public MainController(BookService bookService, AuthorService authorService) {
    this.bookService = bookService;
    this.authorService = authorService;
  }
  
  @RequestMapping(value = "", method = RequestMethod.GET)
  public ModelAndView index()
  {	 
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("books", bookService.findBooksAll());
	  	modelAndView.addObject("authors", authorService.findAuthorsAll());   
	    return modelAndView;	  
  
  }

}