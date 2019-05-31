package by.cources.spring.task2.spring.repository;

import javax.sql.DataSource;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import by.cources.spring.task2.spring.repository.JdbcTemplateAuthorRepository;
import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.repository.mapping.AuthorMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateAuthorRepository implements AuthorRepository {

  private final JdbcTemplate jdbcTemplate;

  public JdbcTemplateAuthorRepository(DataSource ds) {
    this.jdbcTemplate = new JdbcTemplate(ds);
  }

  @Override
  public List <Author> findAll() {
    return jdbcTemplate.query("select * from author", new AuthorMapper());
  }

  @Override
  public Author findById(Long id) {
    return jdbcTemplate.queryForObject("select * from author where id = ?", new Object[]{id}, new AuthorMapper());
  }
    
  @Override
  public List<Author> findAuthorsWhoWasBornSince(LocalDate year) {
	    return  jdbcTemplate.query("select * from author where dateOfBirth > ?", new Object[]{Date.valueOf(year)}, new AuthorMapper());
	  }
  
}
