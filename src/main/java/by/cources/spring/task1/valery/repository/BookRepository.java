package by.cources.spring.task1.valery.repository;

import by.cources.spring.task1.valery.Book;

import java.util.List;

public interface BookRepository {

  List<Book> findAll();
}
