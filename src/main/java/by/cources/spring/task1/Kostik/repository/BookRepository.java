package by.cources.spring.task1.Kostik.repository;

import by.cources.spring.task1.Kostik.Book;

import java.util.List;

public interface BookRepository {

  List<Book> findAll();
}
