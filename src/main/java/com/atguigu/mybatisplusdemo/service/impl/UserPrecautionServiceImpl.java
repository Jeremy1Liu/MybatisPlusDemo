package com.atguigu.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mybatisplusdemo.pojo.UserPrecaution;
import com.atguigu.mybatisplusdemo.service.UserPrecautionService;
import com.atguigu.mybatisplusdemo.mapper.UserPrecautionMapper;
import org.springframework.stereotype.Service;

/**
* @author Quanle
* @description 针对表【user_precaution】的数据库操作Service实现
* @createDate 2023-12-01 18:27:39
*/
@Service
public class UserPrecautionServiceImpl extends ServiceImpl<UserPrecautionMapper, UserPrecaution>
    implements UserPrecautionService{

}




