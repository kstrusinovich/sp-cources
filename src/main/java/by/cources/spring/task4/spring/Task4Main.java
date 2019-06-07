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

    Book book= createBook("BookName1",author,1995L,"spanish");
    service.saveBook(book);
    System.out.println("Saved book with id = " + book.getId()+" name="+book.getName()+
                      " author="+book.getAuthor()+" language="+book.getLanguage()+
                      " PublishedIn="+book.getPublishedIn());
    book= createBook("BookName2",author,1595L,"french");
    service.saveBook(book);
    System.out.println("Saved book with id = " + book.getId()+" name="+book.getName()+
                       " author="+book.getAuthor()+" language="+book.getLanguage()+
                       " PublishedIn="+book.getPublishedIn());
    book= createBook("BookName3",author,1885L,"russian");
    service.saveBook(book);
    System.out.println("Saved book with id = " + book.getId()+" name="+book.getName()+
                       " author="+book.getAuthor()+" language="+book.getLanguage()+
                       " PublishedIn="+book.getPublishedIn());


    System.out.println(" ALL LANGUAGES---------------------");
    query6(service);
    System.out.println("ALL BOOKS---------------------");
    query1(service);

  }
  private static Book createBook(String name,Author author,Long published,String lang) {
     Language language = new Language();
    language.setName(lang);
    Book book = new Book();
    book.setName(name);
    book.setPublishedIn(published);
    book.setAuthor(author);
    book.setLanguage(language);
   return book;
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
