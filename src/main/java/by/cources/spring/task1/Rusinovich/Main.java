package by.cources.spring.task1.Rusinovich;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        context.getBean("firstBook", Book.class).rotate();
        BookReader bookReader2 = context.getBean("bookReader2", BookReader.class);
        bookReader2.go();
    }

    @Bean("bookReader1")
    public BookReader getBookReader(){return new BookReader();}
    @Bean("bookReader2")
    public BookReader getBookReader1(){return new BookReader();}
    @Bean
    public Book firstBook(){return new Book();}
}
