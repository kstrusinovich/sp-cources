package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Author;

import java.time.LocalDate;
import java.util.List;

public interface AuthorRepository {

    List<Author> findAll();

    Author findById(Long id);
    
    List<Author> findAuthorsWhoWasBornSince(LocalDate year);


}
