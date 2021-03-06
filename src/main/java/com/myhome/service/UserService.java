package com.myhome.service;

import com.myhome.domain.User;
import com.myhome.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional (readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(User user) {
        userRepository.save(user);
        return user.getUid();
    }

    @Transactional
    public User updateUser(Long uid, String password) {
        User user = userRepository.findOne(uid);
        user.setPassword(password);
        return user;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
