package by.cources.spring.task6.repository;

import by.cources.spring.task6.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    @Query("SELECT b FROM Users b WHERE b.login = :login")
    Users findByUserName(@Param("login") String login);

}
