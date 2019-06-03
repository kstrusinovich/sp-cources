package by.cources.spring.task2.spring.model;

import java.time.LocalDate;

public class Book {

  private Long id;
  private Long authorId;
  private String name;
  private LocalDate date;

  public Long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
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
            ", authorId=" + authorId +
            ", name='" + name + '\'' +
            ", date=" + date +
            '}';
  }
}