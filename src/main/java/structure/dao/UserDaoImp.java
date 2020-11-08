package structure.dao;

import org.springframework.stereotype.Repository;
import structure.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("from User").getResultList();
    }
    @Override
    public User getUser(long id) {
        return (User) entityManager.createQuery("FROM User where id = :Id")
                .setParameter("Id", id).getSingleResult();
    }

    @Override
    public void remove(long id) {
        entityManager.createQuery("delete from User where id = :id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public void upDate(User user, long id) {
        User userRemove = entityManager.find(User.class, id);
//        entityManager.createQuery("delete from User where id = :id")
//                .setParameter("id", id);
        entityManager.remove(userRemove);
        entityManager.persist(user);
       // entityManager.getTransaction().commit();
    }
}
