package by.cources.spring.task6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity(debug = true)
public class BookSecurityConfig extends WebSecurityConfigurerAdapter {

  private final BookJpaConfig jpaConfig;

  private final UserDetailsService userDetailsService;

  public BookSecurityConfig(BookJpaConfig jpaConfig, UserDetailsService userDetailsService) {
    this.jpaConfig = jpaConfig;
    this.userDetailsService = userDetailsService;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    customAuthentication(auth);
  }

  private void customAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/book/edit/**").hasRole("ADMIN")
        .antMatchers("/book/delete/**").hasRole("ADMIN").antMatchers("/book/find/**").hasRole("USER")
        .antMatchers("/book/**").hasAnyRole("ADMIN", "USER") // .hasRole("USER")
        .antMatchers("/**").hasAnyRole("ADMIN", "USER").and().formLogin().loginProcessingUrl("/book/list").and()
        .exceptionHandling().accessDeniedPage("/403").and().logout().logoutSuccessUrl("/login").permitAll()
        .and().csrf().disable();
  }
}