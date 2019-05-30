package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Book;
import java.util.List;

public interface BookRepository 
{
	
	public List<Book> findAll();

	public Book findById(Long id);

	public List <Long> findBooksAfterYear(long year);  
  
}
