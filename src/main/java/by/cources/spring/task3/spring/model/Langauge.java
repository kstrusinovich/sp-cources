package by.cources.spring.task3.spring.model;

import javax.persistence.*;

@Entity
@Table(name="language")
public class Langauge {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "language_generator")
    @TableGenerator(name="language_generator", table="hibernate_sequence", pkColumnName = "sequence_name", pkColumnValue = "next_val")
    @Column(name = "id")
    private Long id;
    @Column(name = "langauge_name")
    private String langaugeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLangaugeName() {
        return langaugeName;
    }

    public void setLangaugeName(String langaugeName) {
        this.langaugeName = langaugeName;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", langaugeName='" + langaugeName +
                '}';
    }
}
