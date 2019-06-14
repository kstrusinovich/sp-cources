package by.cources.spring.task6.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import by.cources.spring.task6.model.User;
import by.cources.spring.task6.model.UserRoleEnum;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		// с помощью нашего сервиса UserService получаем User
		User user = userService.getUser(login);
		if (user == null) {
			throw new UsernameNotFoundException("User not found.");
		}

		// указываем роли для этого пользователя
		Set<GrantedAuthority> roles = new HashSet();
		//roles.add(new SimpleGrantedAuthority(UserRoleEnum.ADMIN.name()));
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		roles.add(new SimpleGrantedAuthority("USER"));

		// на основании полученных данных формируем объект UserDetails
		// который позволит проверить введенный пользователем логин и пароль
		// и уже потом аутентифицировать пользователя
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(),
				user.getPassword(), roles);

		return userDetails;
	}

}