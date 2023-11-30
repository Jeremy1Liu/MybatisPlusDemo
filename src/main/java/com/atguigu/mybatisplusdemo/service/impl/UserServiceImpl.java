package com.atguigu.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mybatisplusdemo.pojo.User;
import com.atguigu.mybatisplusdemo.service.UserService;
import com.atguigu.mybatisplusdemo.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Quanle
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-11-30 15:12:13
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




