package com.galaxyt.capricorn.mybatis;


import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.galaxyt.capricorn.mybatisplus.MybatisPlusApplication;
import com.galaxyt.capricorn.mybatisplus.dao.UserDao;
import com.galaxyt.capricorn.mybatisplus.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisPlusApplication.class)
public class MyBatisPlusTests {


    @Autowired
    private UserDao userDao;


    @Test
    public void test() {




        for (int i = 0; i < 100; i++) {

            System.out.println(IdWorker.getId());




        }



    }



}
