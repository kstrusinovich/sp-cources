package by.cources.spring.task6.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

@Entity
// @Entity Эта аннотация указывает Hibernate, что данный класс является сущностью
@Table(name = "book")
// @Table С помощью этой аннотации мы говорим Hibernate,
// с какой именно таблицей необходимо связать (map) данный класс
public class Book {

  @Id
  // С помощью аннотации @Id мы указываем первичный ключ (Primary Key) данного класса
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  //Эта аннотация используется вместе с аннотацией @Id
  // и определяет такие паметры, как strategy и generator

  @Column(name = "id")
  //@Column определяет к какому столбцу в таблице БД
  // относится конкретное поле класса (аттрибут класса)
  private Long id;

  @Column(name = "name")
  @Size(min = 1, message = "required")
  //  @Size реализуюет проверку длины значения аннотированного свойства.
  //  Размер аннотированного элемента должен быть между заданными границами
  private String name;

  //@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  //@JoinColumn(name = "author_id")
  //@JsonIgnore
  @ManyToOne(optional = false, cascade = { PERSIST, DETACH, MERGE, REFRESH })
  // @ManyToOne определяет отношение многие к одному — когда множество объект сущности (Entity класса)
  // ссылается на один объект другой сущности
  @JoinColumn(name = "author_id")
  // @JoinColumn задаёт имя столбца, в котором будет храниться ссылка на владеемый объект.
  @JsonIgnore
  // @JsonIgnore  аннотация игнорирует данный атрибут
  // и в результате конвертирования он не будет добавлен в JSON
  @Valid
  private Author author;

  @Column(name = "published_in")
  @NotNull(message = "? not null ?")
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

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", publishedIn=" + publishedIn +
        '}';
  }
}