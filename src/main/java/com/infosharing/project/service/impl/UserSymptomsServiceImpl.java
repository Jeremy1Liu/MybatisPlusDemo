package com.infosharing.project.service.impl;

import com.infosharing.project.pojo.Symptoms;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infosharing.project.pojo.UserSymptoms;
import com.infosharing.project.service.UserSymptomsService;
import com.infosharing.project.mapper.UserSymptomsMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    implements UserSymptomsService {

  private static final Logger logger = LoggerFactory.getLogger(UserSymptomsService.class);
  @Autowired
  UserSymptomsMapper userSymptomsMapper;

  @Override
  public List<Symptoms> getSymptomsByUserId(Integer id) {
    userSymptomsMapper.getSymptomsByUserId(id);
    return null;
  }

  @Override
  public void saveUserAndSymptoms(int savedId, List<Integer> symptoms) {
    for (Integer symptom : symptoms) {
      try {
        UserSymptoms userSymptoms = new UserSymptoms();
        userSymptoms.setUserId(savedId);
        userSymptoms.setSymptomsId(symptom);
        userSymptomsMapper.insert(userSymptoms);
      } catch (Exception e) {
        logger.error("Error occurred while saving user symptom for user ID " + savedId + " and symptom ID " + symptom, e);
      }
    }
  }
}




