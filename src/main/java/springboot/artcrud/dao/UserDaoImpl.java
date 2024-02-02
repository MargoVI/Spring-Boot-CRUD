package springboot.artcrud.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springboot.artcrud.models.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<User> findAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public User findOne(int id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(int id, User updatedUser) {
        entityManager.merge(updatedUser);
    }

    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}