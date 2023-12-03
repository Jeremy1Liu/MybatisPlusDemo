package com.atguigu.mybatisplusdemo.mapper;

import com.atguigu.mybatisplusdemo.pojo.UserSymptoms;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Quanle
* @description 针对表【user_symptoms】的数据库操作Mapper
* @createDate 2023-12-01 19:55:07
* @Entity com.atguigu.mybatisplusdemo.pojo.UserSymptoms
*/
public interface UserSymptomsMapper extends BaseMapper<UserSymptoms> {


  void getSymptomsByUserId(Integer id);
}




