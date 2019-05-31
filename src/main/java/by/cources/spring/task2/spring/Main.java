package by.cources.spring.task2.spring;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.repository.AuthorRepository;
import by.cources.spring.task2.spring.repository.BookRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.h2.util.DateTimeUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws ParseException {
        // SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
        BookRepository service = ctx.getBean(BookRepository.class);
        AuthorRepository serviceAuthor = ctx.getBean(AuthorRepository.class);
        List<Book> all = service.findAll();
        List<Author> allAuthor = serviceAuthor.findAll();
        LocalDate date = LocalDate.of(1965, 12, 31);
        // allAuthor.forEach(item -> System.out.println(item));

        //  all.forEach(item-> System.out.println(item));
        for (Book book : all) {
            if (book.getDate().isAfter(date)) {
                for (Author author : allAuthor) {
                    if (author.getId_author().equals(book.getId_author())) {
                        //System.out.println("All books " + book);
                        System.out.println(author.getName_author());
                    }
                }
            }
        }
        long id = 4L;
        //System.out.println("Book with id = " + id + " is " + service.findById(id));
    }
}
