package by.cources.spring.task6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import by.cources.spring.task6.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity(debug = true)
public class BookSecurityConfig extends WebSecurityConfigurerAdapter 
{
	/**  **/
	private final BookJpaConfig jpaConfig;

	/**  **/
	private MyUserDetailsService userDetailsService;
	
	
	public BookSecurityConfig(BookJpaConfig jpaConfig, MyUserDetailsService userDetailsService) 
	{
		this.jpaConfig = jpaConfig;
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public PasswordEncoder passwordEncoder() 
	{
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		jdbcAuthentication(auth);  
		// inMemoryAuthentication(auth);
		// authenticationProvider(auth);
	}

	/**
	 * 
	 * @param auth
	 * @throws Exception
	 */
	private void authenticationProvider(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.authenticationProvider(authenticationProvider());
	}
  
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
 
  private void inMemoryAuthentication(AuthenticationManagerBuilder auth) throws Exception 
  {
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
        .withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/login").permitAll()
        .antMatchers("/author/**").hasRole("ADMIN")
        .antMatchers("/user/**").hasRole("ADMIN")
        .antMatchers("/book/**").hasRole("ADMIN")
        .antMatchers("/**").hasAnyRole("ADMIN", "USER")
        .and().formLogin().defaultSuccessUrl("/")
        .and().logout().logoutSuccessUrl("/login").permitAll()
        .and().csrf().disable();
  }
}
