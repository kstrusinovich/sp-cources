package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.repository.mapping.AuthorMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateAuthorRepository implements AuthorRepository
{
	private final JdbcTemplate jdbcTemplate;

  
	public JdbcTemplateAuthorRepository(DataSource ds) 
	{
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public List<Author> findAll() 
	{
		return jdbcTemplate.query("select * from author", new AuthorMapper());
	}

	@Override
	public Author findById(Long id)
	{
		return jdbcTemplate.queryForObject("select * from author where id = ?", new Object[]{id}, new AuthorMapper());
	}
	
}