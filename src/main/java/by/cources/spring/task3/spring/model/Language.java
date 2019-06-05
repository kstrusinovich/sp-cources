package by.cources.spring.task3.spring.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="language")
public class Language {

    @Id
    //@GeneratedValue(strategy = GenerationType.TABLE, generator = "language_generator")
    //@TableGenerator(name="language_generator", table="hibernate_sequence", pkColumnName = "sequence_name", pkColumnValue = "next_val")

    @Column(name = "id")
    private Long id;

    @Column(name = "language_name")
    private String languageName;

    @OneToMany(mappedBy = "language")
    private List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
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
                ", languageName='" + languageName +
                '}';
    }
}
