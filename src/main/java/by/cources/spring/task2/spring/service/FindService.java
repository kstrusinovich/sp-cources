package by.cources.spring.task2.spring.service;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.repository.AuthorRepository;
import by.cources.spring.task2.spring.repository.BookRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindService 
{	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	AuthorRepository authorRepository;

	
	public List < Book > findAllBooks()
	{
		return bookRepository.findAll();
	}
	
	public Book findBookById(Long id)
	{
		return bookRepository.findById(id);
	}
	
	public List < Author > findAllAuthors()
	{
		return authorRepository.findAll();
	}
	
	public Author findAuthorById(Long id)
	{
		return authorRepository.findById(id);
	}
	
}
