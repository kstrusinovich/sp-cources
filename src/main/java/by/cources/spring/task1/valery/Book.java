package by.cources.spring.task1.valery;

import org.springframework.beans.factory.annotation.Autowired;

public class Book {
  private String bookName;

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  @Override
  public String toString() {
    return "Book{" +
            "bookName='" + bookName + '\'' +
            '}';
  }
}