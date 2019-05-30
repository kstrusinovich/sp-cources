package by.cources.spring.task2.spring.repository.mapping;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {

    public Author mapRow(ResultSet resultSet, int i) throws SQLException {

        Author personAuthor = new Author();
        personAuthor.setId(resultSet.getInt("id"));
        personAuthor.setNameAuthor(resultSet.getString("name"));
        return personAuthor;
    }
}
