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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

  @PostMapping(value = "/saveBook")
    @ResponseBody
    public ResponseEntity<List<Book>> saveBookPost(@RequestBody Book book) {
        List<Author> authors = bookService.findAuthorsAll();
        List<Language> languages = bookService.findLanguagesAll();
        book.setAuthor(authors.get(0));
        book.setLanguage(languages.get(0));
        bookService.saveBook(book);
        return  new ResponseEntity<>(bookService.findBooksAll(), HttpStatus.OK);
    }

  @PostMapping(value = "/saveBookAndNewLang")
    @ResponseBody
    public ResponseEntity<List<Language>> saveBookAndNewLang(@RequestBody Book book, @RequestParam String nameLanguage) {
        List<Author> authors = bookService.findAuthorsAll();
        book.getLanguage().setLanguageName(nameLanguage);

        book.setAuthor(authors.get(0));
        //book.setLanguage(languages.get(0));
        bookService.saveBookAndNewLang(book);
        return  new ResponseEntity<>(bookService.findLanguagesAll(), HttpStatus.OK);
    }
}