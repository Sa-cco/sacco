package com.example.demo.controller;

import com.example.demo.JsonResult;
import com.example.demo.compont.ModleUser;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/swagger")
@Api(value = "swagger2 在线接口文档")
public class TestController {

    @GetMapping("/get/{id}")
    @ApiOperation(value = "根据用户的唯一标识获取用户信息")
    public ResponseEntity<?> getUserInfo(@PathVariable @ApiParam(value = "用户唯一标识")Long id){
        ModleUser modleUser =new ModleUser(id,"wanglqiiang","wanglqiaing");
        return  new ResponseEntity<ModleUser>(modleUser,HttpStatus.OK);
    }

    @GetMapping("/userList")
    @ApiOperation(value = "获取用户列表")
    public ResponseEntity<?> getUserList(@RequestParam @ApiParam(value = "查询条件")String query){
        Gson gson=new Gson();
        List<ModleUser> modleUserList=new ArrayList<>();
        return new ResponseEntity<List<ModleUser>>(modleUserList,HttpStatus.OK);
    }

    @GetMapping("/get")
    @ApiOperation(value = "测试")
    public JsonResult<?> getUser(){
        ModleUser modleUser =new ModleUser(132L,"wanglqiiang","wanglqiaing");
        System.out.println(modleUser);
        return  new JsonResult<ModleUser>(modleUser);
    }

}
