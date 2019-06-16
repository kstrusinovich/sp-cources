package by.cources.spring.task6.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

  @GetMapping("/")
  public ModelAndView index(Principal user) {
    String messageWelcome = "Hello " + user.getName() + " !";
    Map<String, Object> model = new HashMap();
    model.put("welcome", messageWelcome);
    return new ModelAndView("welcome-index", model);
  }
}
