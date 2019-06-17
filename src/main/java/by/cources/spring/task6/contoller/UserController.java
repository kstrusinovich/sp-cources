package by.cources.spring.task6.contoller;

import by.cources.spring.task6.field.Role;
import by.cources.spring.task6.model.Author;
import by.cources.spring.task6.model.User;
import by.cources.spring.task6.service.AuthorService;
import by.cources.spring.task6.service.BookService;
import by.cources.spring.task6.service.UserService;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

  public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  private final UserService userService;


  public UserController(UserService userService) {
    this.userService = userService;
    
  }

  @RequestMapping(value = "/insert", method = RequestMethod.GET)
  public ModelAndView formInsert() {
	User user = new User();
	user.setPassword("");
    return populateForm("insert", user);
  }

  @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
  public ModelAndView formUpdate(@PathVariable("id") Long id) {
	  User form = userService.findById(id);
	  form.setPassword("");
    return populateForm("update", form);
  }
  
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
  public ModelAndView formDelete(@PathVariable("id") Long id) {
	  User form = userService.findById(id);
    return populateForm("delete", form);
  }

  private ModelAndView populateForm(String mode, User form) {
    ModelAndView modelAndView = new ModelAndView("user-form");
    modelAndView.addObject("mode", mode);
    modelAndView.addObject("user", form);
    modelAndView.addObject("roleList", Role.MENU);    
    return modelAndView;
  }

  @RequestMapping(value = "/edit/{mode}", method = RequestMethod.POST)
  public ModelAndView submit(
      @PathVariable("mode") String mode,
      @Valid @ModelAttribute("user") User user, BindingResult result) {
    ModelAndView modelAndView = new ModelAndView("redirect:/");
    try {
      if (result.hasErrors()) {
        throw new Exception(result.getAllErrors().toString());
      }
      userService.saveUser(mode, user);
    } catch (Exception ex) {
      modelAndView = new ModelAndView("user-form");
      modelAndView.addObject("errorMessage", ex.getMessage());
      modelAndView.addObject("user", user);
      modelAndView.addObject("mode", mode);
    }
    return modelAndView;
  }
}