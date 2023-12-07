package com.infosharing.project.service;

import com.infosharing.project.pojo.User;
import com.infosharing.project.pojo.UserDTO;
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

  UserDTO getUserById(Integer id);

  int deleteUserById(Integer id);

  int updateUser(UserDTO userDTO);
}
