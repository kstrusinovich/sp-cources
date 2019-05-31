package by.cources.spring.task2.spring.repository.mapping;

import by.cources.spring.task2.spring.model.Autor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AutorMapper implements RowMapper<Autor> {

  public Autor mapRow(ResultSet resultSet, int i) throws SQLException {

    Autor person = new Autor();
    person.setId(resultSet.getLong("id"));
    person.setName(resultSet.getString("name"));
    person.setDateOfBirth(resultSet.getDate("dateofbirth"));
    return person;
  }
}
