package by.cources.spring.task2.spring.model;

import java.util.Date;

public class Book {

  private Long id;
  private String name;
  private Long id_autor;
  private Date date_edition;

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
  public Long getIdAutor() {
    return id_autor;
  }

  public void setIdAutor(Long id_autor) { this.id_autor = id_autor; }

  public Date getDateEdition() {
    return date_edition;
  }

  public void setDateEdition(Date date_edition) { this.date_edition = date_edition; }

  @Override
  public String toString() {
    return "Book{id=" + id + ", name='" + name + "\'}";
  }
}