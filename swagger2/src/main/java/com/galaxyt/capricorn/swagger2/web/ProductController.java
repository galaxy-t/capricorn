package com.galaxyt.capricorn.swagger2.web;

import com.galaxyt.capricorn.swagger2.model.dto.UserInfoDTO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("商品API")
@RestController
@RequestMapping("/product")
public class ProductController {


    @ApiOperation(value = "删除商品", notes = "根据主键ID删除商品")
    @ApiImplicitParam(name = "productId", value = "商品主键ID", paramType = "PATH", required = true, dataType = "Long")
    @ApiResponses(@ApiResponse(code = 200,response = UserInfoDTO.class,message = "成功返回"))
    @DeleteMapping("/product/{productId}")
    public String product(@PathVariable("productId") Long productId) {

        System.out.println(productId);


        return "SUCCESS";
    }






}
