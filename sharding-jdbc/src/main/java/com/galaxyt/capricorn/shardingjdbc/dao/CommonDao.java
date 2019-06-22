package com.galaxyt.capricorn.shardingjdbc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.galaxyt.capricorn.shardingjdbc.entity.Common;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonDao extends BaseMapper<Common> {


    @Select(" SELECT * FROM t_common ")
    List<Common> selectAll();
}
