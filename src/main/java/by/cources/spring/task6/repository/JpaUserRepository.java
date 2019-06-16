/*
package by.cources.spring.task6.repository;

import by.cources.spring.task6.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaUserRepository  implements UserRepository {

  @PersistenceContext
  private EntityManager em;

  //@Override
  @Transactional
  public User findUserAccount(String value) {
    String hql = "Select e from " +User.class.getName() + " e "
            + " Where e.userName = :value ";
    TypedQuery<User> query = em.createQuery(hql, User.class);
    query.setParameter("value", value);
    return (User) query.getSingleResult();
  }

 */
/* public List<String> getRoleNames(Long userId) {
    String sql = "Select ur.appRole.roleName from " + UserRole.class.getName() + " ur " //
            + " where ur.appUser.userId = :userId ";

    Query query = this.entityManager.createQuery(sql, String.class);
    query.setParameter("userId", userId);
    return query.getResultList();
  }*//*



}
*/
