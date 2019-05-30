package by.cources.spring.task2.spring.repository.mapping;

import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.model.Author;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book> {

  public Book mapRow(ResultSet resultSet, int i) throws SQLException {

    Book person = new Book();
    person.setId(resultSet.getLong("id"));
    person.setName(resultSet.getString("name"));
    return person;
  }
  public Author mapRow(ResultSet resultSet, int i) throws SQLException {

    Author person = new Author();
    person.setId(resultSet.getLong("id"));
    person.setName(resultSet.getString("name"));
    return person;
  }
}