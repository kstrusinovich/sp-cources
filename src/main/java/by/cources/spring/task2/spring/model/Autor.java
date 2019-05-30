package by.cources.spring.task2.spring.model;

import java.util.Date;

public class Autor {

  private Long id;
  private String name;
  private Date dateOfBirth;
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Book{id=" + id + ", name='" + name + "\'}";
  }
}