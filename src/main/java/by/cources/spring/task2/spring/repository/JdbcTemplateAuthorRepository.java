package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Author;
import java.util.List;
import javax.sql.DataSource;
import by.cources.spring.task2.spring.repository.mapping.Authormapper;
import by.cources.spring.task2.spring.repository.mapping.BookMapper;
import com.sun.istack.Nullable;
import org.springframework.jdbc.core.JdbcTemplate;

    public class JdbcTemplateAuthorRepository implements AuthorRepository {

        private final JdbcTemplate jdbcTemplate;

        public JdbcTemplateAuthorRepository(DataSource ds) {
            this.jdbcTemplate = new JdbcTemplate(ds);
        }


        @Override
        public List<Author> findAll() {
            return jdbcTemplate.query("select * from Author", new Authormapper());
        }

        @Override
        public Author findById(Long id) {
            return jdbcTemplate.queryForObject("select * from Author where id = ?", new Object[]{id}, new Authormapper());
            }
       @Override
       public List<Author> findByyear(Long year){ return jdbcTemplate.query("select a.* from Author a,Book b where b.authorid = a.id and year>?",new Object[]{year}, new Authormapper()); }

    }
