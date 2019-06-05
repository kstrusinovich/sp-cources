package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Book;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateBookRepository implements BookRepository {

  private final JdbcTemplate jdbcTemplate;

  public JdbcTemplateBookRepository(DataSource ds) {
    this.jdbcTemplate = new JdbcTemplate(ds);
  }

  @Override
  public List<Book> findAll() {
    return jdbcTemplate.query("select * from book", new BeanPropertyRowMapper<>(Book.class));
  }

  @Override
  public Book findById(Long id) {
    return jdbcTemplate.queryForObject("select * from book where id = ?", new Object[]{id},  new BeanPropertyRowMapper<>(Book.class));
  }
}
