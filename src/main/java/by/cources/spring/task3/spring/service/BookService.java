package by.cources.spring.task3.spring.service;

import by.cources.spring.task3.spring.model.Author;
import by.cources.spring.task3.spring.model.Book;
import java.util.List;

public interface BookService {

//  List<Book> findBooksAll();
//
//  List<Author> findAuthorsWithBookOlderThan(Long value);
//
//  List<Book> findBooksWithBookOlderThan(String value);
//
//  List<Book> findBooksWithBookName(String value);
//
//  List<Author> findAuthorsAll();


  List<Book> findBooksOnLanguage(String value);
}
