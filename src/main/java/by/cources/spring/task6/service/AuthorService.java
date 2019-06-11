package by.cources.spring.task6.service;

import by.cources.spring.task6.model.Author;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.validation.BindingResult;

public interface AuthorService {
 
  List<Author> findAuthorsWithBookOlderThan(Long value);
 
  List<Author> findAuthorsAll();

  @Transactional
  void saveAuthor(String mode, Author author, BindingResult result) throws Exception;

  Author getForm(String mode, Long id);
  
  
}
