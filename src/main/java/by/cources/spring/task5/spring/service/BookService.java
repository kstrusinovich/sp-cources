package by.cources.spring.task5.spring.service;

import by.cources.spring.task5.spring.model.Author;
import by.cources.spring.task5.spring.model.Book;
import by.cources.spring.task5.spring.model.Language;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

public interface BookService {

	List<Book> findBooksAll();

	Author saveAuthor(Author author);

	List<Author> findAuthorsWithBookOlderThan(Long value);

	List<Book> findBooksWithBookOlderThan(Long value);

	List<Book> findBooksWithBookName(String value);

	List<Author> findAuthorsAll();

	Book saveBook(Book book);

	Optional<Author> findAuthorById(Long id);

	List<Author> findAuthorByName(String firstName, String lastName);

	List<Language> findLangByName(String name);
	
	List<Language> findLangAll();

	void delBook(Book book);
	
	Optional<Book> findBookById(Long id);

}
