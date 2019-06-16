package by.cources.spring.task6.service;

import by.cources.spring.task6.model.User;
import java.util.List;
import javax.transaction.Transactional;

public interface UserService {

  List<User> findUsersAll();

  User findById(Long id);

  void saveUser(String mode, User user);

}
