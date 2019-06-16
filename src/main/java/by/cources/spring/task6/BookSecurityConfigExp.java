package by.cources.spring.task6;

import javax.sql.DataSource;
//import by.cources.spring.task6.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity(debug = true)
public class BookSecurityConfigExp extends WebSecurityConfigurerAdapter {

  private final BookJpaConfig jpaConfig;

  public BookSecurityConfigExp(BookJpaConfig jpaConfig) {
    this.jpaConfig = jpaConfig;
  }

/*
  @Autowired
  private UserDetailsServiceImpl userDetailsService;
*/

  @Autowired
  private DataSource dataSource;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      jdbcAuthentication(auth);
    //auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    inMemoryAuthentication(auth);
  }

  private void inMemoryAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .passwordEncoder(passwordEncoder())
        .withUser("user").password(passwordEncoder().encode("123456")).roles("USER")
        .and()
        .withUser("admin").password(passwordEncoder().encode("123456")).roles("USER", "ADMIN");
  }

  private void jdbcAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(jpaConfig.dataSource())
        .withDefaultSchema()
        .passwordEncoder(passwordEncoder())
        .withUser("user").password(passwordEncoder().encode("123456")).roles("USER")
        .and()
        .withUser("admin").password(passwordEncoder().encode("123456")).roles("USER", "ADMIN");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/login").permitAll()
        .antMatchers("/book/edit/**").hasRole("ADMIN")
        .antMatchers("/book/delete/**").hasRole("ADMIN")
        .antMatchers("/book/**").hasRole("USER")
        .antMatchers("/book/find/**").hasRole("USER")
        .antMatchers("/book/list/**").hasAnyRole("ADMIN", "USER")
        .and().exceptionHandling().accessDeniedPage("/403")
        .and().formLogin().loginProcessingUrl("/book/list")
        .and().logout().logoutSuccessUrl("/login").permitAll()
        .and().csrf().disable();

  }
  /*@Bean
  public PersistentTokenRepository persistentTokenRepository() {
    JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
    db.setDataSource(dataSource);
    return db;
  }*/
}
