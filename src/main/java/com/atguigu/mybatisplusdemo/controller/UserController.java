package com.atguigu.mybatisplusdemo.controller;

import com.atguigu.mybatisplusdemo.mapper.DiseaseMapper;
import com.atguigu.mybatisplusdemo.mapper.PrecautionMapper;
import com.atguigu.mybatisplusdemo.mapper.UserMapper;
import com.atguigu.mybatisplusdemo.pojo.Disease;
import com.atguigu.mybatisplusdemo.pojo.Precaution;
import com.atguigu.mybatisplusdemo.pojo.Symptoms;
import com.atguigu.mybatisplusdemo.pojo.User;
import com.atguigu.mybatisplusdemo.pojo.UserDTO;
import com.atguigu.mybatisplusdemo.service.DiseaseService;
import com.atguigu.mybatisplusdemo.service.PrecautionService;
import com.atguigu.mybatisplusdemo.service.UserPrecautionService;
import com.atguigu.mybatisplusdemo.service.UserService;
import com.atguigu.mybatisplusdemo.service.UserSymptomsService;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

  @Autowired UserMapper userMapper;

  @Autowired UserService userService;

  @Autowired PrecautionMapper precautionMapper;

  @Autowired PrecautionService precautionService;

  @Autowired UserPrecautionService userPrecautionService;

  @Autowired UserSymptomsService userSymptomsService;

  //   //get all disease
  //   @GetMapping("/disease")
  //   public List<Disease> getAllDisease() {
  //      List<Disease> diseases = diseaseService.list();
  //      System.out.println(diseases);
  //      return diseases;
  //   }

  @PostMapping("/user/create")
  public int createUser(@RequestBody UserDTO userDTO) {

    int savedId = userService.insert(userDTO);

    // insert user precautions
    List<Integer> precautions = userDTO.getPrecautions();
    precautionService.saveUserAndPrecautions(savedId, precautions);

    List<Integer> symptoms = userDTO.getSymptoms();
    userSymptomsService.saveUserAndSymptoms(savedId, symptoms);
    System.out.println(userDTO);
    return savedId;
  }

  //    update user
  @PostMapping("/user")
  public int updateUser(@RequestBody User user) {
    int res = userMapper.updateById(user);
    System.out.println(user);
    return res;
  }

  @GetMapping("/user/{id}")
  public User getUserById(@PathVariable("id") Integer id) {
    return userService.getById(id);
  }

  @GetMapping("/usersFullInfo")
  public List<UserDTO> getAllUsersFullInfo() {
    List<UserDTO> userDTOs = userService.getAllUsersFullInfo();
    return userDTOs;
  }

  @GetMapping("/users")
  public List<User> getAllUsers() {
    List<User> users = userMapper.selectList(null);
    return users;
  }

    @DeleteMapping("/user/{id}")
  public int deleteUserById(@PathVariable("id") Integer id) {
    int res = userService.deleteUserById(id);
    return res;
  }

//  update user
    @PutMapping("/user")
  public int updateUser( @RequestBody UserDTO userDTO) {
    int res = userService.updateUser(userDTO);
    return res;
  }

}
