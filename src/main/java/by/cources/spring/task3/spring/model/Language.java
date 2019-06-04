package by.cources.spring.task3.spring.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Shpakovski on 04.06.2019.
 */

@Entity
@Table(name = "language")
public class Language {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String languageName;



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


    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", languageName='" + languageName + '\'' +
                '}';
    }
}
