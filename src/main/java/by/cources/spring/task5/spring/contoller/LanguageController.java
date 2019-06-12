package by.cources.spring.task5.spring.contoller;

import by.cources.spring.task5.spring.model.Language;
import by.cources.spring.task5.spring.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    private final BookService bookService;

    public LanguageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/allLang", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Language>> sample1(ModelMap model) {
        return new ResponseEntity<>(bookService.findLanguagesAll(), HttpStatus.OK);
    }

}
