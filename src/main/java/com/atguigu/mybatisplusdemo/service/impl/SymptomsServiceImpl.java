package com.atguigu.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mybatisplusdemo.pojo.Symptoms;
import com.atguigu.mybatisplusdemo.service.SymptomsService;
import com.atguigu.mybatisplusdemo.mapper.SymptomsMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Quanle
 * @description 针对表【symptoms】的数据库操作Service实现
 * @createDate 2023-12-01 18:02:57
 */
@Service
public class SymptomsServiceImpl extends ServiceImpl<SymptomsMapper, Symptoms>
    implements SymptomsService {

  @Autowired SymptomsMapper symptomsMapper;

  @Override
  public List<Integer> getSymptomsIDsByUserId(Integer id) {
    return null;
  }

  @Override
  public List<Symptoms> getSymptomsByUserId(Integer id) {
    List<Symptoms> symptoms = symptomsMapper.getSymptomsByUserId(id);
    return symptoms;
  }

  @Override
  public List<Symptoms> getSymptomsByDiseaseId(Integer diseaseId) {
    List<Symptoms> symptoms = symptomsMapper.getSymptomsByDiseaseId(diseaseId);
    return symptoms;
  }

  @Override
  public List<Symptoms> getSymptomsByDiseaseName(String diseaseName) {
    List<Symptoms> symptoms = symptomsMapper.getSymptomsByDiseaseName(diseaseName);
    return symptoms;
  }

  @Override
  public void deleteSymptomsByUserId(Integer id) {
    symptomsMapper.deleteSymptomsByUserId(id);
  }
}
