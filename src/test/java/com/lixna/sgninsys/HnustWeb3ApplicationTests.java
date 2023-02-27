package com.lixna.sgninsys;

import com.lixna.sgninsys.entity.User;
import com.lixna.sgninsys.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
class HnustWeb3ApplicationTests {

    @Resource
    UserService userService;
    @Test
    void test() {
        User user = userService.getById(1);
        System.out.println(user.getPhone());
    }

}
