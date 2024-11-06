package org.acumen.training.codes.dao;

import org.acumen.training.codes.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

public class UserDao {
    private EntityManager em;

    public UserDao(String pu) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(pu);
        em = factory.createEntityManager();
    }

    @Transactional
    public boolean insert(User user) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(user);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
    //Password validation
    public User findUserByCredentials(String email, String password) {
        TypedQuery<User> query = em.createQuery(
            "SELECT u FROM User u WHERE u.email = :email AND u.password = :password", User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;  
        }
    }
}
