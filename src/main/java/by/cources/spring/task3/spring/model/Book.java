package by.cources.spring.task3.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

  @Id
  @Column(name = "id")
  private Long id;
  @Column(name = "name")
  private String name;
  @ManyToOne
  @JoinColumn(name = "author_id")
  private Author author;
  @Column(name = "published_in")
  private Long publishedIn;
  @OneToMany(targetEntity = Language.class)
  @JoinColumn(name = "langauge_id",referencedColumnName="id")

  public Long getPublishedIn() {
    return publishedIn;
  }

  public void setPublishedIn(Long publishedIn) {
    this.publishedIn = publishedIn;
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

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", publishedIn=" + publishedIn +
        '}';
  }
}