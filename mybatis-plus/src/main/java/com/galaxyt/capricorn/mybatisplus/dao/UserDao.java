package com.galaxyt.capricorn.mybatisplus.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.galaxyt.capricorn.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;



@Repository
public interface UserDao extends BaseMapper<User> {



    @DS("mysql2")
    @Select(" SELECT COUNT(*) FROM t_policy_keyword_association ")
    Integer getCount();




}
