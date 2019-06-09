package by.cources.spring.task5.spring.model;

import javax.persistence.*;
import java.util.List;

/**
 * ����
 *
 * @author Home
 */
@Entity
@Table(name = "language")
public class Language 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy="language",cascade = CascadeType.ALL)
  private List<Book> books;

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

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  @Override
  public String toString() {
    return "Language{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", books=" + books +
            '}';
  }
}