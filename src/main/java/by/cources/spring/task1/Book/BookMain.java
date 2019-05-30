package by.cources.spring.task1.Book;

import by.cources.spring.task1.spring.Car;
import by.cources.spring.task1.spring.Main;
import by.cources.spring.task1.spring.Wheel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BookMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        ctx.getBean("firstWheel", BookReport.class).findAll();

         BookReport book = new BookReport();
         book.findAll();
    }
}
