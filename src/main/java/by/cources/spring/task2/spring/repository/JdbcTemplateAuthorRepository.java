package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.repository.mapping.AuthorMapper;
import by.cources.spring.task2.spring.repository.mapping.BookMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateAuthorRepository implements AuthorRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateAuthorRepository(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }


    public List<Author> findAll() {
        return jdbcTemplate.query("select * from Author", new BeanPropertyRowMapper<>(Author.class));
    }

    @Override
    public Author findById(Long id) {
        return jdbcTemplate.queryForObject("select * from Author where id = ?", new Object[]{id},  new BeanPropertyRowMapper<>(Author.class));
    }

}
