package by.cources.spring.task1.lesya.repository;

import by.cources.spring.task1.lesya.Book;

import java.util.List;

public interface BookRepository {

  List<Book> findAll();
}
