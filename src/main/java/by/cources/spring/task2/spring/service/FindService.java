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
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;

	
	public List < Book > findAllBooks()
	{
		return bookRepository.findAll();
	}
	
	public void findBookById(Long id)
	{
		Book book = bookRepository.findById(id);
		System.out.println("Book with id = " + id + " is " + book);		
	}
	
	public List < Author > findAllAuthors()
	{
		return authorRepository.findAll();
	}
	
	public void findAuthorById(Long id)
	{		
		Author author = authorRepository.findById(id);
		System.out.println("Author with id = " + id + " is " + author);		
	}

	public void viewAuthors(List <Author> all2) 
	{		
		for (Author author : all2) {
			System.out.println(author);
		}		
	}

	public void viewBooks(List <Book> all) 
	{		
		for (Book book : all) {
			System.out.println(book);
		}
		
	}

	public void findAuthorsWithBooksAfterYear(long year)
	{
		System.out.println("Authors with books after " + year + " year:");
		List <Long> authorIdList = bookRepository.findBooksAfterYear(year);
		for (Long authorId : authorIdList) 
		{
			Author author = authorRepository.findById(authorId);
			System.out.println("   " + author);
		}
	}
	
}