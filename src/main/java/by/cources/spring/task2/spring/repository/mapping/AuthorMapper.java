package by.cources.spring.task2.spring.repository.mapping;

import by.cources.spring.task2.spring.model.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {
   
	@Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setId(rs.getLong("id"));
        author.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
        author.setName(rs.getString("name"));
        return author;
    }
}
