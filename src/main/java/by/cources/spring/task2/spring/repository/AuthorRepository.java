package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Author;

import java.util.List;

/**
 * Created by Shpakovski on 31.05.2019.
 */
public interface AuthorRepository {

    List<Author> findAll();

}
