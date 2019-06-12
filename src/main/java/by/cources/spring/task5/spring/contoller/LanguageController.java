package by.cources.spring.task5.spring.contoller;

import by.cources.spring.task5.spring.model.Language;
import by.cources.spring.task5.spring.service.BookService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lang")
public class LanguageController {

  private final BookService bookService;

  public LanguageController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<List<Language>> sample5() {
    return new ResponseEntity<>(bookService.findLanguagesAll(), HttpStatus.OK);
  }

  // @GetMapping(value = "/sample6/{language}")
  // @ResponseBody
  // public List<Book> sample6(@PathVariable("language") String language) {
  //     return bookService.findBooksWithBookOlderThan(language);
  // }
}
