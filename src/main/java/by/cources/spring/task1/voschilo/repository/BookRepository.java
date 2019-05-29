package by.cources.spring.task1.voschilo.repository;

import by.cources.spring.task1.voschilo.Book;
import java.util.List;

public interface BookRepository {

  List<Book> findAll();
}
