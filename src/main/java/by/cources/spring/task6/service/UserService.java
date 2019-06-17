package by.cources.spring.task6.service;
import by.cources.spring.task6.model.User;
import java.util.List;
import javax.transaction.Transactional;
import java.util.Optional;

public interface UserService {
    String findUserByLogin(String login);
}
