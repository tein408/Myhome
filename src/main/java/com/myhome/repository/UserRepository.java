package com.myhome.repository;

import com.myhome.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(User user) {
        if (user.getUid() == null) {
            em.persist(user);
        } else {
            em.merge(user);
        }
    }

    public User findOne(Long uid) {
        return em.find(User.class, uid);
    }

}
