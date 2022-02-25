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
import java.util.List;

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

    @Test
    public void 회원전체조회() throws Exception {
        //given
        User user = new User();
        user.setId("아이디");
        user.setPassword("비밀번호");
        user.setRole(Role.USER);

        User user1 = new User();
        user1.setId("아이디1");
        user1.setPassword("비밀번호1");
        user1.setRole(Role.USER);

        User user2 = new User();
        user2.setId("아이디2");
        user2.setPassword("비밀번호2");
        user2.setRole(Role.USER);

        //when
        userService.save(user);
        userService.save(user1);
        userService.save(user2);

        //then
        List<User> userList = userRepository.findAll();
        Assertions.assertEquals(3, userList.size());
    }

}