package by.cources.spring.task2.spring.repository.mapping;

import by.cources.spring.task2.spring.model.Author;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authormapper implements RowMapper<Author> {

    public Author mapRow(ResultSet resultSet, int i) throws SQLException {

        Author person = new Author();
        person.setId(resultSet.getLong("id"));
        person.setName(resultSet.getString("name"));
        return person;
    }
}