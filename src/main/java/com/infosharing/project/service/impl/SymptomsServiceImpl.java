package com.infosharing.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infosharing.project.pojo.Symptoms;
import com.infosharing.project.service.SymptomsService;
import com.infosharing.project.mapper.SymptomsMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author Quanle
 * @description 针对表【symptoms】的数据库操作Service实现
 * @createDate 2023-12-01 18:02:57
 */
@Service
public class SymptomsServiceImpl extends ServiceImpl<SymptomsMapper, Symptoms>
    implements SymptomsService {

  private static final Logger logger = LoggerFactory.getLogger(SymptomsService.class);

  @Autowired SymptomsMapper symptomsMapper;

  @Override
  public List<Integer> getSymptomsIDsByUserId(Integer id) {
    try {
      return symptomsMapper.getSymptomsIDsByUserId(id);
    } catch (Exception e) {
      logger.error("Error occurred while fetching symptom IDs for user ID " + id, e);
      return Collections.emptyList();
    }
  }

  @Override
  public List<Symptoms> getSymptomsByUserId(Integer id) {
    try {
      return symptomsMapper.getSymptomsByUserId(id);
    } catch (Exception e) {
      logger.error("Error occurred while fetching symptoms for user ID " + id, e);
      return Collections.emptyList();
    }
  }

  @Override
  public List<Symptoms> getSymptomsByDiseaseId(Integer diseaseId) {
    try {
      return symptomsMapper.getSymptomsByDiseaseId(diseaseId);
    } catch (Exception e) {
      logger.error("Error occurred while fetching symptoms for disease ID " + diseaseId, e);
      return Collections.emptyList();
    }
  }

  @Override
  public List<Symptoms> getSymptomsByDiseaseName(String diseaseName) {
    try {
      return symptomsMapper.getSymptomsByDiseaseName(diseaseName);
    } catch (Exception e) {
      logger.error("Error occurred while fetching symptoms for disease named " + diseaseName, e);
      return Collections.emptyList();
    }
  }

  @Override
  public void deleteSymptomsByUserId(Integer id) {
    symptomsMapper.deleteSymptomsByUserId(id);
  }
}
