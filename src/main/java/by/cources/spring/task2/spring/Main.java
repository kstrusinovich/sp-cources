package by.cources.spring.task2.spring;
import java.util.Date;
import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.model.Autor;
import by.cources.spring.task2.spring.repository.AutorRepository;
import by.cources.spring.task2.spring.repository.BookRepository;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args)throws ParseException {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
    BookRepository service = ctx.getBean(BookRepository.class);
    AutorRepository service2 = ctx.getBean(AutorRepository.class);


    List<Book> all = service.findAll();
    for (Book book : all) {
      System.out.println("All books " + book);
    }
    long id = 3L;
    System.out.println("Book with id = " + id + " is " + service.findById(id));

    List<Autor> a = service2.findAllAutor();
    for (Autor autor : a) {
         System.out.println("Author "+autor );
    }

      String sourceDate  = "1965-12-31";
      SimpleDateFormat dat = new SimpleDateFormat("yyyy-MM-dd");
      Date date = dat.parse(sourceDate);

      List<Autor> a2 = service2.findAutor(date);
      System.out.println("Autors who's edition older then 1965 " + a2);


  }
}
