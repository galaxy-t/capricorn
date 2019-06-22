package com.galaxyt.capricorn.shardingjdbc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.galaxyt.capricorn.shardingjdbc.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends BaseMapper<User> {


    @Insert(" INSERT INTO t_user(id,username,password) VALUES(#{id},#{username},#{password}) ")
    void add(User user);

    @Select(" SELECT * FROM t_user ")
    List<User> selectAll();


}
