package com.galaxyt.capricorn.user.inter;

import com.galaxyt.capricorn.user.model.entity.User;
import com.galaxyt.capricorn.user.vo.LoginVo;

public interface IUserService {


    User login(LoginVo vo);



}
