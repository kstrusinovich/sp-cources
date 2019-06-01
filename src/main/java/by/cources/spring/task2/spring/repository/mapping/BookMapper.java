package by.cources.spring.task2.spring.repository.mapping;

import by.cources.spring.task2.spring.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book> {

  public Book mapRow(ResultSet resultSet, int i) throws SQLException {

    Book person = new Book();
    person.setId(resultSet.getLong("id"));
    person.setName(resultSet.getString("name"));
    person.setIdAuthor(resultSet.getLong("id_author"));
    return person;
  }

}
