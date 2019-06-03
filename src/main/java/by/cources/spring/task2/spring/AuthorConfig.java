package by.cources.spring.task2.spring;


import by.cources.spring.task2.spring.repository.AuthorRepository;
import by.cources.spring.task2.spring.repository.AuthorService;
import by.cources.spring.task2.spring.repository.JdbcTemplateAuthorRepository;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



@Configuration
@PropertySource("classpath:task2/database.properties")
public class AuthorConfig {

  @Autowired
  Environment environment;

  @Bean
  AuthorRepository jdbcAuthorRepository() {
    return new JdbcTemplateAuthorRepository(dataSource());
  }

  @Bean
  AuthorService authorServices(){
    return new AuthorService(jdbcAuthorRepository());
  }
  @Bean
  DataSource dataSource() {
    DriverManagerDataSource source = new DriverManagerDataSource();
    source.setUrl(environment.getProperty("url"));
    source.setUsername(environment.getProperty("dbuser"));
    source.setPassword(environment.getProperty("dbpassword"));
    source.setDriverClassName(environment.getProperty("driver"));
    return source;
  }

}
