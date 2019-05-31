package by.cources.spring.task2.spring.model;

import java.sql.Date;
import java.time.LocalDate;

public class Book {

  private Long id;
  private Long id_author;
  private String name;
  private LocalDate date;

  public Long getId_author() {
    return id_author;
  }

  public void setId_author(Long id_author) {
    this.id_author = id_author;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "Book{" +
            "id=" + id +
            ", id_author=" + id_author +
            ", name='" + name + '\'' +
            ", date=" + date +
            '}';
  }
}