package by.cources.spring.task5.spring.contoller;

import by.cources.spring.task5.spring.model.Author;
import by.cources.spring.task5.spring.model.Book;
import by.cources.spring.task5.spring.service.BookService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<List<Book>> sample1(ModelMap model) {
    return new ResponseEntity<>(bookService.findBooksAll(), HttpStatus.OK);
  }

  @DeleteMapping(value = "/delete/{id}")
  //@ResponseBody
  public ResponseEntity<Long> delete(@PathVariable Long id) {
    bookService.deleteById(id);
    return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
  }
}