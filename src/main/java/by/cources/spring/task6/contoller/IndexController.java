package by.cources.spring.task6.contoller;

import by.cources.spring.task6.model.User;
import by.cources.spring.task6.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class IndexController {

  private final UserService userService;

  public IndexController(UserService userService) {
    this.userService = userService;
  }
 /* @GetMapping("/")
  public String index() {
    return "index";
  }*/
  @GetMapping("/")
  public ModelAndView index(Principal user) {
    ModelAndView model = new ModelAndView("index");
   // String user_name = userService.findUserByLogin(user.getName());
   // model.addObject("user_name", user_name );
    model.addObject("user_name", user.getName());
    return model;
  }
  /*@RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView username(@PathVariable("login") String login) {
    Optional<User> user = userService.findUserByLogin(login);

    if (user.isPresent()) {
      return new ModelAndView("index", "user", user.get());
    }

    ModelAndView errorModel = new ModelAndView("error");
    errorModel.addObject("errorMessage", "USER NOT FOUND");
    return errorModel;
  }*/

  @RequestMapping(value = "/403", method = RequestMethod.GET)
  public String accessDenied() {
    return "403";
  }

}
