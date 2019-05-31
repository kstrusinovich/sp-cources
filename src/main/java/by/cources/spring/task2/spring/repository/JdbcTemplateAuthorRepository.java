package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.repository.mapping.AuthorMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Shpakovski on 31.05.2019.
 */
public class JdbcTemplateAuthorRepository implements AuthorRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateAuthorRepository(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }


    public List<Author> findAll() {
        return jdbcTemplate.query("select * from author", new AuthorMapper());
    }
}
