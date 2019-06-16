/*
package by.cources.spring.task6.service;

import by.cources.spring.task6.model.User;

import by.cources.spring.task6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private UserRepository userRepository;

 */
/* @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    User user = this.userRepository.findbyLogin(userName);

    if (appUser == null) {
      System.out.println("User not found! " + userName);
      throw new UsernameNotFoundException("User " + userName + " was not found in the database");
    }

    System.out.println("Found User: " + appUser);

    // [ROLE_USER, ROLE_ADMIN,..]
    List<String> roleNames = this.appRoleDAO.getRoleNames(appUser.getUserId());

    List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
    if (roleNames != null) {
      for (String role : roleNames) {
        // ROLE_USER, ROLE_ADMIN,..
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
        grantList.add(authority);
      }
    }


    UserDetails userDetails = (UserDetails) new User(appUser.getName(), //
            appUser.getPassword(), grantList);

    return userDetails;
  }
*//*

  @Override
  @Transactional
  public List<User> findUserWithUserLogin(String value) {
    return userRepository.findByLogin(value);
  }

  private <T> List<T> toList(Iterable<T> items) {
    List<T> list = new ArrayList<>();
    for (T t : items) {
      list.add(t);
    }
    return list;
  }
//  https://o7planning.org/ru/11705/create-a-login-application-with-spring-boot-spring-security-jpa
}
*/
