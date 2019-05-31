package by.cources.spring.task2.spring.repository.mapping;
import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.model.Book;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Shpakovski on 31.05.2019.
 */
public class AuthorMapper  implements RowMapper<Author> {


    public Author mapRow(ResultSet resultSet, int i) throws SQLException {

        Author person = new Author();
        person.setId_author(resultSet.getLong("id_author"));
        person.setName_author(resultSet.getString("name_author"));
        return person;
    }
}
