package com.atguigu.mybatisplusdemo.controller;

import com.atguigu.mybatisplusdemo.mapper.DiseaseMapper;
import com.atguigu.mybatisplusdemo.mapper.UserMapper;
import com.atguigu.mybatisplusdemo.pojo.Disease;
import com.atguigu.mybatisplusdemo.pojo.User;
import com.atguigu.mybatisplusdemo.service.DiseaseService;
import com.atguigu.mybatisplusdemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

  @Autowired
  DiseaseService diseaseService;

  @Autowired
  DiseaseMapper diseaseMapper;

  @Autowired
  UserMapper userMapper;

  @Autowired
  UserService userService;

   //get all disease
   @GetMapping("/disease")
   public List<Disease> getAllDisease() {
      List<Disease> diseases = diseaseService.list();
      System.out.println(diseases);
      return diseases;
   }

   @PostMapping("/user/create")
    public int createUser(@RequestBody User user) {
      int res = userMapper.insert(user);
      System.out.println(user);
      return res;
    }

//    update user
    @PostMapping("/user")
    public int updateUser(@RequestBody User user) {
      int res = userMapper.updateById(user);
      System.out.println(user);
      return res;
    }



}
