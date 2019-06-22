package com.galaxyt.capricorn.mongodb;

import com.galaxyt.capricorn.mongodb.spring.User;
import com.galaxyt.capricorn.mongodb.spring.dao.UserDao;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoDBApplication.class)
public class UserDaoTests {


    @Autowired
    private UserDao userDao;

    @Ignore
    @Test
    public void saveTest() {

        User user = new User();
        user.setName("CCOOOOOOOOOO");

        user = this.userDao.save(user);

        System.out.println(user.getId());
        System.out.println(user.getName());


    }

    @Ignore
    @Test
    public void removeTest() {

        long result = this.userDao.remove(3333L);

        System.out.println(result);

    }

    @Test
    public void updateTest() {


        User user = new User();
        user.setId("5d09e9fc6153762011a2b2c9");
        user.setName("ERROR");
        long result = this.userDao.update(user);

        System.out.println(result);

    }

    @Ignore
    @Test
    public void findTest() {


        User user = this.userDao.findById(11111L);

        System.out.println(user.getId());
        System.out.println(user.getName());
    }





}
