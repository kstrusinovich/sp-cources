package by.cources.spring.task2.spring.service;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.model.Book;

import java.util.List;

public interface BookAuthorService {

    List<Book> findAllBooks();

    Book findBookById(Long id);

    List<Author> findAllAuthors();

    Author findAuthorById(int id);

    List<Author> findAuthorsWithBookOlder(Long publicationYear);
}
