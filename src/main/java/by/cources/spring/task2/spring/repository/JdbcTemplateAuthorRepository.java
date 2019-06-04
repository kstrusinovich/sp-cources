package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.repository.mapping.AuthorMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateAuthorRepository implements AuthorRepository {

    private final JdbcTemplate jdbcTemplateAuthor;

    public JdbcTemplateAuthorRepository(DataSource ds) {

        this.jdbcTemplateAuthor = new JdbcTemplate(ds);
    }

    @Override
    public List<Author> findAll(){

        return jdbcTemplateAuthor.query("select * from author", new AuthorMapper());
    }

    @Override
    public Author findById(int id){

        return jdbcTemplateAuthor.queryForObject("select * from author where id = ?", new Object[]{id}, new AuthorMapper());
    }

    @Override
    public List<Author> findAuthorsWithBookOlder(Long publicationYear){

        return jdbcTemplateAuthor.query("SELECT * FROM author WHERE id IN (SELECT author_id FROM book WHERE published_in>?)", new Object[]{publicationYear}, new AuthorMapper());
    }

}
