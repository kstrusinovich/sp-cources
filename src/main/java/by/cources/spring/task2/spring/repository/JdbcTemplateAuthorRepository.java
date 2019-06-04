package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.repository.mapping.AuthorMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateAuthorRepository implements AuthorRepository {

    private final JdbcTemplate jdbcTemplateAutor;

    public JdbcTemplateAuthorRepository(DataSource ds) {
        this.jdbcTemplateAutor = new JdbcTemplate(ds);
    }

    @Override
    public List<Author> findAll(){
        return jdbcTemplateAutor.query("SELECT * FROM author", new AuthorMapper());
    }

    @Override
    public Author findById(int idAuthor){
        return jdbcTemplateAutor.queryForObject("SELECT * FROM author WHERE id = ?", new Object[]{idAuthor}, new AuthorMapper());
    }

    @Override
    public List<Author> findAuthorsWithBookOlder(Long publicationYear){
        return jdbcTemplateAutor.query("SELECT * FROM author WHERE id IN (SELECT author_id FROM book WHERE published_in>?)", new Object[]{publicationYear}, new AuthorMapper());
    }
}
