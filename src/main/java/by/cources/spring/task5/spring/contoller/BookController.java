package by.cources.spring.task5.spring.contoller;

import by.cources.spring.task5.spring.model.Author;
import by.cources.spring.task5.spring.model.Book;
import by.cources.spring.task5.spring.model.Language;
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


 /* @PostMapping(value = "/savebook")
  @ResponseBody
  public List<Book> sample2(@RequestBody Book book) {

    book.setName(book.getName());
    book.setAuthor(book.getAuthor());
    book.setPublishedIn(book.getPublishedIn());
    book.setLanguage(book.getLanguage());

    bookService.saveBook(book);
    return bookService.findBooksAll();

  }
*/

  /*@DeleteMapping(value = "/delete/{id}")
  @ResponseBody
  public List<Book> deleteBook(@PathVariable("id") Long id) {

   //bookService.findBookById(id).ifPresent(
    bookService.deleteBook(id);
     return bookService.findBooksAll();
  }*/
}