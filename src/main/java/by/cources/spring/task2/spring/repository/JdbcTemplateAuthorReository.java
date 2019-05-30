package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.repository.mapping.AuthorMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateAuthorReository implements AuthorRepository {

    private final JdbcTemplate jdbcTemplateAutor;

    public JdbcTemplateAuthorReository(DataSource ds) {
        this.jdbcTemplateAutor = new JdbcTemplate(ds);
    }

    @Override
    public List<Author> findAll(){
        return jdbcTemplateAutor.query("select * from book", new AuthorMapper());
    }

    @Override
    public Author findByIdAuthor(int idAuthor){
        return jdbcTemplateAutor.queryForObject("select * from book where id = ?", new Object[]{idAuthor}, new AuthorMapper());
    }
}
