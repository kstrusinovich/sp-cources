package by.cources.spring.task6.service;

import by.cources.spring.task6.field.EditMode;
import by.cources.spring.task6.model.User;
import by.cources.spring.task6.repository.UserRepository;
import by.cources.spring.util.TextUtil;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService 
{
  private final UserRepository userRepository;
    
  private final PasswordEncoder passwordEncoder;
  
  
  public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) 
  {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Transactional
  @Override
  public List<User> findUsersAll() {
    return TextUtil.toList(userRepository.findAll());
  }

  @Override
  public User findById(Long id) 
  {	
	return userRepository.findById(id).get();
  }

  @Override
  public void saveUser(String mode, User user) 
  {	  
	  user.setPassword(passwordEncoder.encode(user.getPassword()));
	  
	  if (mode.equals(EditMode.INSERT) || mode.equals(EditMode.UPDATE)) {
		  userRepository.save(user);
	  }
	  if (mode.equals(EditMode.DELETE)) {
		  userRepository.delete(user);
	  }
	
  }

}
