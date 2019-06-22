package com.galaxyt.capricorn.shardingjdbc.service;

import com.galaxyt.capricorn.shardingjdbc.dao.CommonDao;
import com.galaxyt.capricorn.shardingjdbc.dao.UserDao;
import com.galaxyt.capricorn.shardingjdbc.entity.Common;
import com.galaxyt.capricorn.shardingjdbc.entity.User;
import com.galaxyt.capricorn.shardingjdbc.inter.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private CommonDao commonDao;


    @Override
    public void save() {


        for (long i = 0; i < 100; i++) {
            User user = new User();

            user.setId(i);
            user.setUsername("zhouqi123");
            user.setPassword("abcdefg");

            if (i < 50) {
                user.setSex(0);
            } else {
                user.setSex(1);

            }



            this.userDao.insert(user);
        }






    }






    @Override
    public List<User> list() {

        //强制路由
        //要求查询使用主库
        //HintManager.getInstance().setMasterRouteOnly();



        return this.userDao.selectAll();
    }

    @Override
    @Transactional
    public void add() {

        User user = new User();

        user.setId(200L);
        user.setUsername("测试事物");
        user.setPassword("abcdefg");

        user.setSex(0);

        this.userDao.insert(user);


        User user1 = new User();

        user1.setId(201L);
        user1.setUsername("测试事物");
        user1.setPassword("abcdefg");

        user1.setSex(1);

        this.userDao.insert(user1);

        int i = 1/0;


        User user2 = new User();

        user2.setId(204L);
        user2.setUsername("测试事物");
        user2.setPassword("abcdefg");

        user2.setSex(0);

        this.userDao.insert(user2);



    }

    @Override
    public void defaultAdd() {


        Common common = new Common();
        common.setAbcd("abcd");

        this.commonDao.insert(common);


    }

    @Override
    public List<Common> defaultList() {
        return this.commonDao.selectAll();
    }
}
