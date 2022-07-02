package com.project.wallet.repository;

import com.project.wallet.domain.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository{

    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<User> findByUserId(Long user_id) {
        User user = em.find(User.class, user_id);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByUserName(String name) {
        User user = em.find(User.class,name);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }
}
