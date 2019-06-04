package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Author;
import java.util.List;

public interface AuthorRepository {


  List<Author> findAll();

  Author findById(Long id);

  List<Author> findByyear(Long year);
}
