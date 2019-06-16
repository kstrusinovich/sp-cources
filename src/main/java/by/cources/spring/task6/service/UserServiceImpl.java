package by.cources.spring.task6.service;

import org.springframework.stereotype.Service;

import by.cources.spring.task6.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(String login) {
        User user = new User();
        user.setLogin(login);
        user.setPassword("$2a$10$oSi2sdkYQrNqkytI.sYeMeSSv3ka7PgFSh6pafilpgbu/pB6bYzg.");
        //user.setPassword(new BCryptPasswordEncoder().encode("123456"));
        return user;
    }

}
