package by.cources.spring.task1.valery.repository;

import by.cources.spring.task1.valery.Book;

import java.util.Arrays;
import java.util.List;

public class InMemoryBookRepository implements BookRepository {

	private List<Book> cache = Arrays.asList(new Book("book1", "ivanov"), new Book("book2", "petrov"));

	@Override
	public List<Book> findAll() {
		return cache;
	}
}
