package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Autor;
import by.cources.spring.task2.spring.repository.mapping.BookMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateAutorRepository implements AutorRepository {

  private final JdbcTemplate jdbcTemplate;

  public JdbcTemplateAutorRepository(DataSource ds) {
    this.jdbcTemplate = new JdbcTemplate(ds);
  }

 // @Override
 // public List<Book> findAll() {
//    return jdbcTemplate.query("select * from book", new BookMapper());
 // }

 // @Override
 // public Book findById(Long id) {
 //   return jdbcTemplate.queryForObject("select * from book where id = ?", new Object[]{id}, new BookMapper());
 // }
}
