package com.atguigu.mybatisplusdemo.service.impl;

import com.atguigu.mybatisplusdemo.controller.UserController;
import com.atguigu.mybatisplusdemo.mapper.DiseaseMapper;
import com.atguigu.mybatisplusdemo.mapper.DoctorMapper;
import com.atguigu.mybatisplusdemo.mapper.HospitalMapper;
import com.atguigu.mybatisplusdemo.pojo.Disease;
import com.atguigu.mybatisplusdemo.pojo.Doctor;
import com.atguigu.mybatisplusdemo.pojo.Hospital;
import com.atguigu.mybatisplusdemo.pojo.Precaution;
import com.atguigu.mybatisplusdemo.pojo.Symptoms;
import com.atguigu.mybatisplusdemo.pojo.UserDTO;
import com.atguigu.mybatisplusdemo.service.HospitalService;
import com.atguigu.mybatisplusdemo.service.PrecautionService;
import com.atguigu.mybatisplusdemo.service.SymptomsService;
import com.atguigu.mybatisplusdemo.service.UserSymptomsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mybatisplusdemo.pojo.User;
import com.atguigu.mybatisplusdemo.service.UserService;
import com.atguigu.mybatisplusdemo.mapper.UserMapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author Quanle
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-11-30 15:12:13
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

  @Autowired
  UserMapper userMapper;

  @Autowired
  HospitalMapper hospitalMapper;

  @Autowired
  DiseaseMapper diseaseMapper;

  @Autowired
  DoctorMapper doctorMapper;

  @Autowired
  SymptomsService symptomsService;

  @Autowired
  PrecautionService precautionService;

  @Autowired
  UserSymptomsService userSymptomsService;

//  public List<User> getUsersFullInfo() {
//    QueryWrapper<User> wrapper = new QueryWrapper<>();
//    wrapper.isNotNull("hospital_id");  // 筛选出hospital_id不为空的用户
//
//    List<User> users = userMapper.selectList(wrapper);
//    // 使用关联查询
//    for (User user : users) {
//      Hospital hospital = hospitalMapper.selectById(user.getHospitalId());
//      if (hospital != null) {
//
//      }
//    }
//    return users;
//  }


  @Override
  public List<UserDTO> getAllUsersFullInfo() {
    List<User> users = userMapper.selectList(null);
    ModelMapper modelMapper = new ModelMapper();
    List<UserDTO> userDTOS = new ArrayList<>();
    for (User user : users) {
      UserDTO userDTO = modelMapper.map(user, UserDTO.class);
      userDTOS.add(userDTO);
      // get disease object

      //get doctor object

      // get Symptoms list
      List<Integer> symptoms = symptomsService.getSymptomsIDsByUserId(userDTO.getId());
      userDTO.setSymptoms(symptoms);

      // get precautions list
      List<Integer> precautions = precautionService.getPrecautionsIDsByUserId(userDTO.getId());
      userDTO.setPrecautions(precautions);

    }
    return userDTOS;
  }

  @Override
  public int insert(UserDTO user) {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.typeMap(UserDTO.class, User.class)
            .addMapping(UserDTO::getDiseaseId, User::setDiseaseId)
            .addMapping(UserDTO::getDoctorId, User::setDoctorId);

    User user1 = modelMapper.map(user, User.class);
    int insert = userMapper.insert(user1);
//    System.out.println("insert: " + user1);

    if(user1.getId() != null) {
      // insert user precautions
      return user1.getId();
    } else{
      return -1;
    }
  }

  @Override
  public UserDTO getUserById(Integer id) {
    User user = userMapper.selectById(id);
    ModelMapper modelMapper = new ModelMapper();
    UserDTO userDTO = modelMapper.map(user, UserDTO.class);
    // get disease object

    //get doctor object

    // get Symptoms list
    List<Integer> symptoms = symptomsService.getSymptomsIDsByUserId(userDTO.getId());
    userDTO.setSymptoms(symptoms);
    List<Integer> precautions = precautionService.getPrecautionsIDsByUserId(userDTO.getId());
    userDTO.setPrecautions(precautions);
    return userDTO;
  }

  @Override
  public int deleteUserById(Integer id) {

    symptomsService.deleteSymptomsByUserId(id);
    precautionService.deletePrecautionsByUserId(id);
    userMapper.deleteById(id);
    return 0;
  }

  @Override
  public int updateUser(UserDTO userDTO) {
    ModelMapper modelMapper = new ModelMapper();
    User user = modelMapper.map(userDTO, User.class);
    int res = userMapper.updateById(user);
    System.out.println(user);
//    delete user precautions, then insert new precautions
    symptomsService.deleteSymptomsByUserId(userDTO.getId());
    precautionService.deletePrecautionsByUserId(userDTO.getId());
    List<Integer> symptoms = userDTO.getSymptoms();
    userSymptomsService.saveUserAndSymptoms(userDTO.getId(), symptoms);
    List<Integer> precautions = userDTO.getPrecautions();
    precautionService.saveUserAndPrecautions(userDTO.getId(), precautions);
    return 0;
  }
}




