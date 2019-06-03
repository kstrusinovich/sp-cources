package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.repository.mapping.BookMapper;
import java.time.LocalDate;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateBookRepository implements BookRepository {

  private final JdbcTemplate jdbcTemplate;

  public JdbcTemplateBookRepository(DataSource ds) {
    this.jdbcTemplate = new JdbcTemplate(ds);
  }

  @Override
  public List<Book> findAll() {
    return jdbcTemplate.query("select * from book", new BookMapper());
  }

  @Override
  public Book findById(Long id) {
    return jdbcTemplate.queryForObject("select * from book where id = ?", new Object[]{id}, new BookMapper());
  }

  @Override
  public List<Book> findByDate(LocalDate date) {
    String sql = "select * from book b join author a ON b.id_author = a.id where a.date < ?";
    return jdbcTemplate.query(sql, new Object[]{date}, new BookMapper());
  }
}

