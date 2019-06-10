package by.cources.spring.task4.spring.model;

import by.cources.spring.task4.spring.model.Language;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  /*
    in @ManyToOne()
    FetchType.EAGER — загружать коллекцию дочерних объектов вместе с загрузкой родительских объектов;
    FetchType.LAZY — загружать коллекцию дочерних объектов при первом обращении к ней (вызове метода get) — это так называемая отложенная загрузка.
   */
  @ManyToOne
  @JoinColumn(name = "author_id")
  private Author author;

//  @ManyToOne(optional=false, cascade = CascadeType.PERSIST)
  @ManyToOne
  @JoinColumn(name = "language_id")
  private Language language;

  @Column(name = "published_in")
  private Long publishedIn;

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
    return "Book{" +
        "id=" + id +
        ", id_author=" + author.getId() +
        ", id_language=" + language.getId() +
        ", name='" + name + '\'' +
        ", publishedIn=" + publishedIn +
        '}';
  }
}