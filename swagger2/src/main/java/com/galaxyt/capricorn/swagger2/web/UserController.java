package com.galaxyt.capricorn.swagger2.web;

import com.galaxyt.capricorn.swagger2.model.dto.UserInfoDTO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api("用户API")
@RestController
@RequestMapping("/user")
public class UserController {


    @ApiOperation(value = "获取用户基础信息",notes = "根据用户主键ID获取用户基础信息")
    @ApiImplicitParams(@ApiImplicitParam(name = "userId",value = "用户主键ID",paramType = "PATH",required = true,dataType = "Long"))
    @ApiResponses(@ApiResponse(code = 200,response = UserInfoDTO.class,message = "成功返回"))
    @GetMapping("info/{userId}")
    public UserInfoDTO info(@PathVariable("userId") Long userId) {

        System.out.println(userId);

        UserInfoDTO dto = new UserInfoDTO();

        dto.setUserId(userId);
        dto.setUsername("Gambler");
        dto.setSex("男");
        dto.setAge(27);

        return dto;
    }

    @ApiOperation(value = "修改用户基础信息",notes = "根据主键ID修改用户基础信息")
    @ApiImplicitParam(dataTypeClass = UserInfoDTO.class)
    @ApiResponses(@ApiResponse(code = 200,response = String.class,message = "成功返回"))
    @PatchMapping("info")
    public String info(@RequestParam UserInfoDTO dto) {

        System.out.println(dto.toString());

        return "SUCCESS";
    }




}
