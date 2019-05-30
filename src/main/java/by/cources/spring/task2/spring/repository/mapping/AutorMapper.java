package by.cources.spring.task2.spring.repository.mapping;

import by.cources.spring.task2.spring.model.Autor;
import by.cources.spring.task2.spring.model.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class AutorMapper implements RowMapper<Autor> {

	public Autor mapRow(ResultSet resultSet, int i) throws SQLException {

		Autor autor = new Autor();
		autor.setId(resultSet.getLong("id"));
		autor.setName(resultSet.getString("name"));
		autor.setBirthDay(resultSet.getDate("birthday"));
		return autor;
	}
}