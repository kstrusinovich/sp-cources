package by.cources.spring.task6.contoller;

import by.cources.spring.task6.model.Author;
import by.cources.spring.task6.service.AuthorService;
import javax.validation.Valid;
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
@RequestMapping("/author")
public class AuthorController {

  public static final Logger LOGGER = LoggerFactory.getLogger(AuthorController.class);

  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @RequestMapping(value = "/edit/{mode}/{id}", method = RequestMethod.GET)
  public ModelAndView formInsert(@PathVariable("mode") String mode, @PathVariable("id") Long id) {
    ModelAndView modelAndView = new ModelAndView("author-form");
    modelAndView.addObject("mode", mode);
    modelAndView.addObject("author", authorService.getForm(mode, id));
    return modelAndView;
  }

  @RequestMapping(value = "/edit/{mode}", method = RequestMethod.POST)
  public ModelAndView submit(@PathVariable("mode") String mode,
      @Valid @ModelAttribute("author") Author author, BindingResult result, ModelMap model) {
    ModelAndView modelAndView = new ModelAndView("redirect:/");
    try {
      if (result.hasErrors()) {
        throw new Exception(/*result.getAllErrors().toString()*/);
      }

      authorService.saveAuthor(mode, author);
    } catch (Exception ex) {
      modelAndView = new ModelAndView("author-form");
      modelAndView.addObject("errorMessage", ex.getMessage());
      modelAndView.addObject("author", author);
      modelAndView.addObject("mode", mode);
    }
    return modelAndView;
  }
}