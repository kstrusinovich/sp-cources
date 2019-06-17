package by.cources.spring.task6.service;

import by.cources.spring.task6.model.User;
import by.cources.spring.task6.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	/*
	@Autowired
	private UserRepository userRepository;
	*/

  private final UserRepository userRepository;

  public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

    // с помощью нашего сервиса UserService получаем User
    User user = userRepository.findByUserName(login);
    //User user = userRepository.findByid(1L);
    //System.out.println("********** " + user);
    if (user == null) {
      throw new UsernameNotFoundException("User not found.");
    }
    return user;
  }
}