package by.cources.spring.task1.Sharay.repository;

import by.cources.spring.task1.Sharay.Book;

import java.util.List;

public interface BookRepository {

  List<Book> findAll();
}
