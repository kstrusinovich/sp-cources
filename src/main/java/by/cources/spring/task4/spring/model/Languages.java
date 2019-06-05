package by.cources.spring.task4.spring.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="languages")
public class Languages {
    @Id
    @Column (name="id")
    private Long id;
    @Column (name="name_languages")
    private String name_languages;

    private List<Book> book;

    public void setBook(List<Book> book) { this.book = book; }

    public List<Book> getBook() { return book; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public void setName_languages(String name_languages) { this.name_languages = name_languages; }

    public String getName_languages() { return name_languages; }

    @Override
    public String toString() { return "languages{" + "id=" + id + "name_languages" + name_languages + "}" ; }
}
