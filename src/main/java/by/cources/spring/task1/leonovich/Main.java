package by.cources.spring.task1.leonovich;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Main {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
    ctx.getBean("book", BookRep.class).findAll();

  }

  @Bean
  public BookRep geBookRep() {
    return new BookRep();
  }

}
