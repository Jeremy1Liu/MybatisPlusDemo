package com.atguigu.mybatisplusdemo;

import com.atguigu.mybatisplusdemo.mapper.DiseaseMapper;
import com.atguigu.mybatisplusdemo.mapper.HospitalMapper;
import com.atguigu.mybatisplusdemo.mapper.UserMapper;
import com.atguigu.mybatisplusdemo.pojo.Disease;
import com.atguigu.mybatisplusdemo.pojo.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusDemoApplicationTests {


  @Autowired
  DiseaseMapper diseaseMapper;

  @Autowired
  UserMapper userMapper;

  @Autowired
  HospitalMapper hospitalMapper;


  @Test
  void testGetAllDisease() {
    List<Disease> diseases = diseaseMapper.selectList(null);
    System.out.println(diseases);
  }

//  test add user
//  name, email, age, gender, hospital_id, disease_i;
  @Test
  void testAddUser() {
    User user = new User();
//    user.setId(1);
    user.setName("test");
    user.setEmail("t@g.com");
    user.setAge(20);
    user.setGender("male");
    int res = userMapper.insert(user);
    System.out.println(res);
  }


  @Test
  void testGetById(){
    List<User> users = userMapper.getById(1);
    System.out.println(users);
  }

  // test delete user by calling Mysql procedure
  @Test
  void testDeleteById(){
    int res = userMapper.deleteById(391745541);
    System.out.println(res);
  }

  @Test
  void testInsertAll() {
    User user = new User();
    user.setName("testInsertprocedure");
    user.setAge(20);

    int i = userMapper.callCreateUserProcedure(user.getName(), user.getEmail(), user.getAge(), user.getGender());
    System.out.println(i);
  }

  @Test
  void testUpdateUser(){
    User user = userMapper.selectById(391745542);
    user.setEmail("a@g.com");
    int res = userMapper.updateById(user);
    System.out.println(res);
  }
}
