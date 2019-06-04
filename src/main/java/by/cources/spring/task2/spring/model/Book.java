package by.cources.spring.task2.spring.model;

public class Book {

  private Long id;
  private String name;
  private Long year;
  private Long authorid;

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

  public Long getYear() {
    return year;
  }

  public void setYear(Long year) {
    this.year = year;
  }

  public Long getAuthorid() {
    return authorid;
  }

  public void setAuthorid(Long authorid) {
    this.authorid = authorid;
  }

  @Override
  public String toString() {
    return "Book{id=" + id + ", name='" + name + "',year=" + year + ",authorid=" + authorid + "}";
  }
}