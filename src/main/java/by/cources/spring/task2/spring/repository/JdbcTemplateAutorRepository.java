package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Autor;
import by.cources.spring.task2.spring.repository.mapping.AutorMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Date;
import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateAutorRepository implements AutorRepository {

  private final JdbcTemplate jdbcTemplate;

  public JdbcTemplateAutorRepository(DataSource ds) {
    this.jdbcTemplate = new JdbcTemplate(ds);
  }

  @Override
  public List<Autor> findAllAutor() {
    return jdbcTemplate.query("select * from autor", new AutorMapper());
  }

  @Override
  public List<Autor> findAutor(Date date) {

    return jdbcTemplate.query("select * from autor a,book b where autor_id = a.id and date_edition>?",new Object[]{date}, new AutorMapper());

  }
}
