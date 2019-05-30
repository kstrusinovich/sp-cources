package by.cources.spring.task2.spring;

import by.cources.spring.task2.spring.model.Autor;
import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookService {

	private BookRepository repository;

	public BookService(BookRepository repository) {
		this.repository = repository;
	}
	
	public List<Book> findAll(String where) {
		List<Book> books = new ArrayList<Book>();
		for (Book book : repository.findAll(where)) {
			book.setAutor(repository.findAutorById(book.getAutorId()));
			books.add(book);
		}
		return books;
	}
	
	public List<Book> findAll() {
		return findAll("");
	}

	public Book findById(Long id) {
		Book book = repository.findById(id);
		book.setAutor(repository.findAutorById(book.getAutorId()));
		return book;
	}
	
	public List<Autor> findAutorByWhere(String where) {
		return repository.findAutorByWhere(where);
	};

}
