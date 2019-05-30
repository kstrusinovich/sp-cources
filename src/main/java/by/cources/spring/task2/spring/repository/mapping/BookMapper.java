package by.cources.spring.task2.spring.repository.mapping;

import by.cources.spring.task2.spring.model.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book> {

	public Book mapRow(ResultSet resultSet, int i) throws SQLException {

		Book book = new Book();
		book.setId(resultSet.getLong("id"));
		book.setName(resultSet.getString("name"));
		book.setYear(resultSet.getInt("year"));
		book.setAutorId(resultSet.getLong("autor"));
		return book;
	}
}