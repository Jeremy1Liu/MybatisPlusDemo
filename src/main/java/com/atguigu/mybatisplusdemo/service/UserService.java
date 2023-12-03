package com.atguigu.mybatisplusdemo.service;

import com.atguigu.mybatisplusdemo.pojo.User;
import com.atguigu.mybatisplusdemo.pojo.UserDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Quanle
* @description 针对表【user】的数据库操作Service
* @createDate 2023-12-01 17:39:25
*/
public interface UserService extends IService<User> {

  List<UserDTO> getAllUsersFullInfo();


  int insert(UserDTO user);
}