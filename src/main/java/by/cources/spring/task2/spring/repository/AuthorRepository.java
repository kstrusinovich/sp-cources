package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Author;
import java.util.List;

public interface AuthorRepository {

  List<Author> findAll();

  public Author findById(Long id);
}
