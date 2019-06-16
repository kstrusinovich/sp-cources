package by.cources.spring.task6.service;

import by.cources.spring.task6.model.User;
import by.cources.spring.task6.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;

  }


  @Override
  @Transactional
  public String findUserByLogin(String login) {
    return userRepository.findByLogin(login);
  }


}
