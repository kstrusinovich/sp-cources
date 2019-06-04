package by.cources.spring.task3.spring.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "language")
public class Language {

  @Id
 /* @GeneratedValue(strategy = GenerationType.TABLE, generator = "language_generator")
  @TableGenerator(name="language_generator", table="hibernate_sequence", pkColumnName = "sequence_name", pkColumnValue = "next_val")
*/  @Column(name = "id")
  private Long id;
  @Column(name = "name")
  private String name;
 // @OneToMany(mappedBy="language")

 /* @OneToMany(mappedBy="author")
  private List<Book> books;

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }*/


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
    return "Language{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}