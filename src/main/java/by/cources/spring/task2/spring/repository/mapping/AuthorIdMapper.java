package by.cources.spring.task2.spring.repository.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class AuthorIdMapper implements RowMapper<Long> {

  public Long mapRow(ResultSet resultSet, int i) throws SQLException 
  {
    return resultSet.getLong("author_id");
  }
}