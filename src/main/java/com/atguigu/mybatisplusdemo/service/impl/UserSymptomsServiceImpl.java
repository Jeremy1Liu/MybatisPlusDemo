package com.atguigu.mybatisplusdemo.service.impl;

import com.atguigu.mybatisplusdemo.pojo.Symptoms;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mybatisplusdemo.pojo.UserSymptoms;
import com.atguigu.mybatisplusdemo.service.UserSymptomsService;
import com.atguigu.mybatisplusdemo.mapper.UserSymptomsMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Quanle
* @description 针对表【user_symptoms】的数据库操作Service实现
* @createDate 2023-12-01 19:55:07
*/
@Service
public class UserSymptomsServiceImpl extends ServiceImpl<UserSymptomsMapper, UserSymptoms>
    implements UserSymptomsService{

  @Autowired
  UserSymptomsMapper userSymptomsMapper;

  @Override
  public void saveUserAndSymptoms(int savedId, List<Symptoms> symptoms) {
    for (Symptoms symptom : symptoms) {
      // save user symptom
      UserSymptoms userSymptoms = new UserSymptoms();
      userSymptoms.setUserId(savedId);
      userSymptoms.setSymptomsId(symptom.getId());
      userSymptomsMapper.insert(userSymptoms);
    }
  }
}




