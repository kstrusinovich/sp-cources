package by.cources.spring.task6.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController 
{

  public static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
  
  
  @RequestMapping(value = "", method = RequestMethod.GET)
  public String form()
  {
  
    return "redirect:/book/list";
  }

}