package by.cources.spring.task1.leonovich;

import org.springframework.beans.factory.annotation.Autowired;

public class BookRep {

  public void setBook(Book book) {
    this.book = book;
  }

  @Autowired
  private Book book;

  public Book getBook() {
    return book;
  }


  public void findAll() {
    System.out.println(book);
    // change position of car
  }
}