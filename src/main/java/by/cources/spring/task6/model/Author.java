package by.cources.spring.task6.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "author")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name = "id")
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  /*@OneToMany(mappedBy="author")
  private List<Book> books;

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }*/

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  public String toString() {
    return "Author{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", dateOfBirth=" + dateOfBirth +
        '}';
  }
}
