package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Autor;
import java.util.Date;
import java.util.List;

public interface AutorRepository {

  List<Autor> findAllAutor();
  List<Autor> findAutor(Date date);
}
