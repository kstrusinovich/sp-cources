package by.cources.spring.task6.service;

import by.cources.spring.task6.model.Users;
import by.cources.spring.task6.repository.UsersRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UsersDetailServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;

    public UsersDetailServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login){

        Users user = usersRepository.findByUserName(login);

        Set<GrantedAuthority> roles = new HashSet();
        for (String role : user.getRoles().split(","))
            roles.add(new SimpleGrantedAuthority(role));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(), roles);
        return userDetails;
    }
}
