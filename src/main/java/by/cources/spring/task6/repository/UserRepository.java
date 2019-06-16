package by.cources.spring.task6.repository;

import by.cources.spring.task6.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> 
{
	/**  **/	
	@Query("select u from User u where u.username = :value")
	User findByUsername(@Param("value") String value); 
	
}