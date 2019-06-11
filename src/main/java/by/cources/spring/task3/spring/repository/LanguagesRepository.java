package by.cources.spring.task3.spring.repository;


import by.cources.spring.task3.spring.model.languages;
import java.util.List;
import java.util.Optional;

public interface LanguagesRepository {

  List<languages> findBooklanguages (Long value);

  Optional<languages> findById(Long id);

  List<languages> findAll();
}
