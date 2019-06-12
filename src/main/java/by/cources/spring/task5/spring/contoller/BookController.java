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

  //пример посылки в postman::POST::localhost:8080/myapp/book/saveBookAndNewLang?nameLanguage=China::body/raw/JSON::вставляем посылку-тело
  @PostMapping(value = "/saveBookAndNewLang")
    @ResponseBody
    public ResponseEntity<List<Language>> saveBookAndNewLang(@RequestBody Book book, @RequestParam String nameLanguage) {
        List<Author> authors = bookService.findAuthorsAll();
        book.setAuthor(authors.get(0));
        Language language = new Language();
        language.setLanguageName(nameLanguage);
        book.setLanguage(language);
        bookService.saveBookAndNewLang(book);
        return  new ResponseEntity<>(bookService.findLanguagesAll(), HttpStatus.OK);
    }

  //пример посылки в postman::DELETE::localhost:8080/myapp/book/delete/3
  @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public List<Book> delete(@PathVariable("id") Long id) {
        //bookService.findBookById(id).ifPresent(book -> bookService.delBook(book));
        bookService.findBookById(id).ifPresent(bookService::delBook);
        return bookService.findBooksAll();
    }
}