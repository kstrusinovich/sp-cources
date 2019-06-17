package by.cources.spring.task6.repository;

import by.cources.spring.task6.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    @Query("select b.name from User b where b.login = :login")
    String findByLogin(@Param("login")String login);
}
