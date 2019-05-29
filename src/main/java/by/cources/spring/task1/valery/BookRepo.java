package by.cources.spring.task1.valery;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class BookRepo {

  private List<Book> bookRep;

  public void setBookRep(List<Book> bookRep) {
    this.bookRep = bookRep;
  }

  public List<Book> getBookRep() {
    return bookRep;
  }
}