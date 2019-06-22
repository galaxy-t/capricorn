package com.galaxyt.capricorn.user.web;

import com.galaxyt.capricorn.common.enums.ResultCode;
import com.galaxyt.capricorn.common.model.dto.ReturnValueLoader;
import com.galaxyt.capricorn.common.util.encript.JWTUtil;
import com.galaxyt.capricorn.user.dto.UserLoginDto;
import com.galaxyt.capricorn.user.inter.IUserService;
import com.galaxyt.capricorn.user.model.entity.User;
import com.galaxyt.capricorn.user.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    private String secret = "abcd";

    @PostMapping("login")
    public ReturnValueLoader login(@Valid @RequestBody LoginVo vo) {

        User user = this.userService.login(vo);



        if (user != null) {

            UserLoginDto dto = new UserLoginDto();

            dto.setId(user.getId());
            dto.setUsername(user.getUsername());
            dto.setAvailable(user.getAvailable());
            dto.setNote(user.getNote());

            String token = JWTUtil.getInstance().generateToken(user.getId().toString(), 60,this.secret);

            dto.setToken(token);

            return new ReturnValueLoader(dto);
        }
        return new ReturnValueLoader(ResultCode.USERNAME_OR_PASSWORD_ERROR);
    }




}
