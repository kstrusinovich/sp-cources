package by.cources.spring.task2.spring.model;

import java.util.Date;

public class Book {

  private Long id;
  private String name;
  private Date dateOfRelise;
  private Long id_author;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDateOfRelise() {
    return dateOfRelise;
  }

  public void setDateOfRelise(Date dateOfRelise) {
    this.dateOfRelise = dateOfRelise;
  }

  public Long getId_author() {
    return id_author;
  }

  public void setId_author(Long id_author) {
    this.id_author = id_author;
  }

  @Override
  public String toString() {
    return "Book{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", dateOfRelise=" + dateOfRelise +
            ", id_author=" + id_author +
            '}';
  }
}