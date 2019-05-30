package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Autor;
import by.cources.spring.task2.spring.model.Book;
import java.util.List;

public interface BookRepository {

	List<Book> findAll(String where);

	Book findById(Long id);

	Autor findAutorById(Long id);
	
	List<Autor> findAutorByWhere(String where);
}
