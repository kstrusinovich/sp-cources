package by.cources.spring.task2.spring.model;

import java.util.Date;

public class Book {

  private Long id;
  private String name;
  private Date dateOfbirth ;
  private int age;
  private String Author;



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

  @Override
  public String toString() {
    return "Book{id=" + id + ", name='" + name + ", Author='" +Author + ", Data= '"= dateOfbirth"/}";
  }
}



