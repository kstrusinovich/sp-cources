package by.cources.spring.task6.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import by.cources.spring.task6.model.User;
import by.cources.spring.task6.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		// с помощью нашего сервиса UserService получаем User
		User user = userRepository.findByUserName(login);
		// User user = userRepository.findByid(1L);
		System.out.println("********** " + user);
		if (user == null) {
			throw new UsernameNotFoundException("User not found.");
		}

		/*
		 * user = new User();
		 *  user.setLogin(login); 
		 *  user.setPassword("$2a$10$oSi2sdkYQrNqkytI.sYeMeSSv3ka7PgFSh6pafilpgbu/pB6bYzg.");
		 * user.setRoles("ROLE_USER,ROLE_ADMIN");
		 */

		// указываем роли для этого пользователя
		Set<GrantedAuthority> roles = new HashSet();
		for (String role : user.getRoles().split(","))
			roles.add(new SimpleGrantedAuthority(role));

		// на основании полученных данных формируем объект UserDetails
		// который позволит проверить введенный пользователем логин и пароль
		// и уже потом аутентифицировать пользователя
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(),
				user.getPassword(), roles);

		return userDetails;
	}

}