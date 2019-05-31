package by.cources.spring.task2.spring.model;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Shpakovski on 31.05.2019.
 */
public class Author {

    private Long id_author;
    private String name_author;

    public Long getId_author() {
        return id_author;
    }

    public void setId_author(Long id_author) {
        this.id_author = id_author;
    }

    public String getName_author() {
        return name_author;
    }

    public void setName_author(String name_author) {
        this.name_author = name_author;
    }


}
