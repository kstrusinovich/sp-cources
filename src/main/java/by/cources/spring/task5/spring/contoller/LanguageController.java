package by.cources.spring.task5.spring.contoller;

import by.cources.spring.task5.spring.model.Author;
import by.cources.spring.task5.spring.model.Book;
import by.cources.spring.task5.spring.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/lang")
public class LanguageController {

    private final BookService bookService;

    public LanguageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Book>> sample5() {
        return new ResponseEntity<>(bookService.findBooksAll(), HttpStatus.OK);
    }

   // @GetMapping(value = "/sample6/{language}")
   // @ResponseBody
   // public List<Book> sample6(@PathVariable("language") String language) {
   //     return bookService.findBooksWithBookOlderThan(language);
   // }

}
