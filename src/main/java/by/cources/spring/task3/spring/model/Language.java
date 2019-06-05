package by.cources.spring.task3.spring.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class Language {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;


}
