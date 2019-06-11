package by.cources.spring.task4.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "name")
  private String name;
  
  @ManyToOne
  @JoinColumn(name = "author_id")
  private Author author;

  @Column(name = "published_in")
  private Long publishedIn;
  
  @ManyToOne//(cascade = CascadeType.ALL)
  @JoinColumn(name = "language_id")
  private Language language;
  
  
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
  
  public Language getLanguage() {
	return language;
  }

  public void setLanguage(Language language) {
	this.language = language;
  }

@Override
  public String toString() {
    return "Book { " +
        "id=" + id +
        ", \"" + name + '\"' +
        ", " + author +
        ", publishedIn=" + publishedIn +
        ", " + language +
        " }";
  }
}