package com.atguigu.mybatisplusdemo.service;

import com.atguigu.mybatisplusdemo.pojo.Symptoms;
import com.atguigu.mybatisplusdemo.pojo.UserSymptoms;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Quanle
* @description 针对表【user_symptoms】的数据库操作Service
* @createDate 2023-12-01 19:55:07
*/
public interface UserSymptomsService extends IService<UserSymptoms> {

  List<Symptoms> getSymptomsByUserId(Integer id);

  void saveUserAndSymptoms(int savedId, List<Integer> symptoms);

}
