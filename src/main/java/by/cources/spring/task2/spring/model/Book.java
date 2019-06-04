package by.cources.spring.task2.spring.model;

public class Book {

  private Long id;
  private String name;
  private String publishedIn;
  private Long authorId;

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

  public String getPublishedIn() {
    return publishedIn;
  }

  public void setPublishedIn(String publishedIn) {
    this.publishedIn = publishedIn;
  }

  public Long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }

  @Override
  public String toString() {
    return "Book{id=" + id + ", name='" + name + ", publishedIn='" + publishedIn + ", authorId='" + authorId +"\'}";
  }
}