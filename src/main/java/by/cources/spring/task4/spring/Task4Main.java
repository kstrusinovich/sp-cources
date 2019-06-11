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
    saveBookSimple(service);
    saveBookAndNewLanguage(service);
    saveBookAndLanguage(service);
    System.out.println("---------------------");
    query1(service);
    System.out.println("---------------------");
    query5(service);
    System.out.println("---------------------");
    query6(service);
  }

  private static void saveBookSimple(BookService service) {
    Author author = createAuthor();
    Language language = service.findLanguageById(2l);

    Book book = createBook(author, language);
    service.saveBookOnly(book);
  }

  public static void saveBookAndNewLanguage(BookService service) {
    Author author = createAuthor();
    //service.saveAuthor(author);

    Language language = new Language();
    String nameLanguage = "China";
    language.setLanguageName(nameLanguage);

    Book book = createBook(author, language);
    service.saveBookAndNewLang(book);
  }

  public static void saveBookAndLanguage(BookService service) {
    Author author = createAuthor();
    //service.saveAuthor(author);

    Language language = new Language();
    language.setLanguageName("English");
    //service.saveLanguage(language);

    Book book = createBook(author, language);
    service.saveBook(book);
  }

  private static Author createAuthor(){
    Author author = new Author();
    author.setLastName("lastName");
    author.setFirstName("firstName");
    author.setDateOfBirth(LocalDate.now());
    return author;
  }

  private static Book createBook(Author author, Language language){
    Book book = new Book();
    book.setAuthor(author);
    book.setLanguage(language);
    book.setName("name");
    book.setPublishedIn(1922L);
    return book;
  }

  private static void query1(BookService service) {
    List< Book> all = service.findBooksAll();
    for ( Book book : all) {
      System.out.println("Query1: " + book);
    }
  }
  
  private static void query5(BookService service) {
    List<Author> authors = service.findAuthorsAll();
    for (Author author : authors) {
      System.out.println("Query5: " + author);
    }
  }

  private static void query6(BookService service) {
    List<Language> languages = service.findLanguagesAll();
    for (Language language : languages) {
      System.out.println("Query6: " + language);
    }
  }
}
