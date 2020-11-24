package structure.dao;

import org.springframework.stereotype.Repository;
import structure.model.Role;
import structure.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Role getOne(Long id) {
        return (Role) entityManager.createQuery("FROM Role where id = :Id")
                .setParameter("Id", id).getSingleResult();    }
}
