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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {



  @Autowired
  UserMapper userMapper;

  @Autowired
  UserService userService;

  @Autowired
  PrecautionMapper precautionMapper;

  @Autowired
  PrecautionService precautionService;

  @Autowired
  UserPrecautionService userPrecautionService;

  @Autowired
  UserSymptomsService userSymptomsService;

//   //get all disease
//   @GetMapping("/disease")
//   public List<Disease> getAllDisease() {
//      List<Disease> diseases = diseaseService.list();
//      System.out.println(diseases);
//      return diseases;
//   }

   @PostMapping("/user/create")
    public int createUser(@RequestBody UserDTO userDTO) {
//      int res = userMapper.insert(user);

      // userDTO to user
//      ModelMapper modelMapper = new ModelMapper();
//      User user = modelMapper.map(userDTO, User.class);

      // insert user base info
      int savedId = userService.insert(userDTO);

      // insert user precautions
      List<Precaution> precautions = userDTO.getPrecautions();
      precautionService.saveUserAndPrecautions(savedId, precautions);

      List<Symptoms> symptoms = userDTO.getSymptoms();
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

    @GetMapping("/users")
    public List<User> getAllUsers() {
      List<User> users = userMapper.selectAllUserWithHospital();
      return users;
    }

  @GetMapping("/precautions")
  public List<Precaution> getPrecautionsByUserId() {
    List<Precaution> precautions = precautionMapper.selectByUserId(1);
    return precautions;
  }


}
