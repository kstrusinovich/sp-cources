package by.cources.spring.task2.spring.model;

import java.util.Date;

public class Autor {

  private Long id;
  private String name;
  private Date dateofbirth;
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public Date getDateOfBirth() {
    return dateofbirth;
  }

  public void setDateOfBirth(Date dateofbirth) {
    this.dateofbirth = dateofbirth;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return  name;
  }
}