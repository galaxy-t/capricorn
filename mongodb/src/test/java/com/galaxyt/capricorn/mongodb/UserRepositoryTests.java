package com.galaxyt.capricorn.mongodb;

import com.galaxyt.capricorn.mongodb.spring.User;
import com.galaxyt.capricorn.mongodb.spring.dao.UserRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoDBApplication.class)
public class UserRepositoryTests {



    @Autowired
    private UserRepository userRepository;

    @Ignore
    @Test
    public void count() {

        long l = this.userRepository.count();


        System.out.println(l);
    }

    @Test
    public void findByName() {

        User user = this.userRepository.findByName("CCOOOOOOOOOO");

        System.out.println(user.getId());

    }





}
