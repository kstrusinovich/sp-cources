package by.cources.spring.task6.service;

import by.cources.spring.task6.field.EditMode;
import by.cources.spring.task6.model.User;
import by.cources.spring.task6.repository.UserRepository;
import by.cources.spring.util.TextUtil;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService 
{
  private final UserRepository userRepository;
  

  public UserServiceImpl(UserRepository userRepository) 
  {
    this.userRepository = userRepository;
  }

  @Transactional
  @Override
  public List<User> findUsersAll() {
    return TextUtil.toList(userRepository.findAll());
  }

}
