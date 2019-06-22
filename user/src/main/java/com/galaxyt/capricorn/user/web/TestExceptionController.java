package com.galaxyt.capricorn.user.web;


import com.galaxyt.capricorn.common.exception.NotFoundException;
import com.galaxyt.capricorn.user.model.entity.User;
import com.galaxyt.capricorn.user.vo.Args;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api("异常测试接口")
@RestController
@RequestMapping("/exception")
public class TestExceptionController {




    @ApiOperation(value = "500错误返回测试",notes = "用于测试服务器内部程序错误发生时，前台接收到的异常信息是否为格式化JSON")
    @ApiImplicitParams(@ApiImplicitParam(name = "id",value = "学生ID",paramType = "PATH",required = true,dataType = "Integer"))
    @ApiResponses(@ApiResponse(code = 200,response = User.class,message = "正常情况返回"))
    @GetMapping("500")
    public String test() {

        int i = 1 / 0;

        return "";
    }


    @GetMapping("nf")
    public String notFound() {

        if (1 == 1) {
            throw new NotFoundException("用户不存在");
        }

        return "";
    }


    @PostMapping("args")
    public String args(@Valid @RequestBody Args args) {




        return "";
    }


    @GetMapping("cs")
    public String cs(){


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Success";

    }

}
