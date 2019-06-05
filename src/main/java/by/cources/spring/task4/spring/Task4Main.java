package by.cources.spring.task4.spring;

import by.cources.spring.task4.spring.model.Author;
import by.cources.spring.task4.spring.model.Book;
import by.cources.spring.task4.spring.model.Language;
import by.cources.spring.task4.spring.service.BookService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Task4Main {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
    BookService service = ctx.getBean(BookService.class);
    System.out.println("---------------------");
    Author author = new Author();
    author.setLastName("lastName");
    author.setFirstName("firstName");
    author.setDateOfBirth(LocalDate.now());
    service.saveAuthor(author);
    System.out.println("Saved author with id = " + author.getId());
    System.out.println("ALL AUTHORS---------------------");
    query5(service);

    Language language = new Language();
    language.setName("russian");

    Book book = new Book();
    book.setName("BookName1");
    book.setPublishedIn(1995L);
    book.setAuthor(author);
    book.setLanguage(language);
    service.saveBook(book);
    System.out.println("Saved book with id = " + book.getId()+" name="+book.getName()+
                      " author="+book.getAuthor()+" language="+book.getLanguage()+
                      " PublishedIn="+book.getPublishedIn());

  /*  Book book2 = new Book();
    book2.setName("BookName2");
    book2.setPublishedIn(1895L);
    book2.setAuthor(author);
    book2.setLanguage(language);
    service.saveBook(book2);
    System.out.println("Saved book with id = " + book2.getId()+" name="+book2.getName()+
            " author="+book2.getAuthor()+" language="+book2.getLanguage()+
            " PublishedIn="+book2.getPublishedIn());
    Book book3 = new Book();
    Language language2 = new Language();
    book3.setName("BookName3");
    book3.setPublishedIn(1907L);
    author.setLastName("lastName3");
    author.setFirstName("firstName3");
    book3.setAuthor(author);
    language2.setName("japan");
    book3.setLanguage(language2);
    service.saveBook(book3);
    System.out.println("Saved book with id = " + book3.getId()+" name="+book3.getName()+
            " author="+book3.getAuthor()+" language="+book3.getLanguage()+
            " PublishedIn="+book3.getPublishedIn());*/

    System.out.println(" ALL LANGUAGES---------------------");
    query6(service);
    System.out.println("ALL BOOKS---------------------");
    query1(service);

  }

  private static void query5(BookService service) {
    List<Author> authors = service.findAuthorsAll();
    for (Author author : authors) {
      System.out.println("Query5: " + author);
    }
  }
  private static void query6(BookService service) {
    List<Language> all = service.findLanguagesAll();
    for (Language language : all) {
      System.out.println("Query6: " + language);
    }
  }
  private static void query1(BookService service) {
    List<Book> all = service.findBooksAll();
    for (Book book : all) {
      System.out.println("Query1: " + book);
    }
  }
}
