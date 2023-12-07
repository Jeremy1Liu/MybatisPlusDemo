package com.infosharing.project.service;

import com.infosharing.project.pojo.Symptoms;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Quanle
* @description 针对表【symptoms】的数据库操作Service
* @createDate 2023-12-01 18:02:57
*/
public interface SymptomsService extends IService<Symptoms> {

  List<Integer> getSymptomsIDsByUserId(Integer id);

  List<Symptoms> getSymptomsByUserId(Integer id);
  
  List<Symptoms> getSymptomsByDiseaseId(Integer diseaseId);

  List<Symptoms> getSymptomsByDiseaseName(String diseaseName);

  void deleteSymptomsByUserId(Integer id);

}
