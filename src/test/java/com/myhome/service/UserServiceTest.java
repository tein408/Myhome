package com.myhome.service;

import com.myhome.domain.Role;
import com.myhome.domain.User;
import com.myhome.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    EntityManager em;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        User user = new User();
        user.setId("아이디");
        user.setPassword("비밀번호");
        user.setRole(Role.USER);

        //when
        Long saveId = userService.save(user);

        //then
        Assertions.assertEquals(user, userRepository.findOne(saveId));
    }

    @Test
    public void 회원정보_수정() throws Exception {
        //given
        User user = new User();
        user.setId("아이디");
        user.setPassword("비밀번호");
        user.setRole(Role.USER);

        //when
        Long saveUid = userService.save(user);
        userService.updateUser(saveUid, "바꾼비밀번호");

        //then
        User changeUser = userRepository.findOne(saveUid);
        Assertions.assertEquals("바꾼비밀번호", changeUser.getPassword());
    }

}