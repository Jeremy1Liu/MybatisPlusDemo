package com.atguigu.mybatisplusdemo.service.impl;

import com.atguigu.mybatisplusdemo.mapper.UserPrecautionMapper;
import com.atguigu.mybatisplusdemo.pojo.UserPrecaution;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mybatisplusdemo.pojo.Precaution;
import com.atguigu.mybatisplusdemo.service.PrecautionService;
import com.atguigu.mybatisplusdemo.mapper.PrecautionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
* @author Quanle
* @description 针对表【precaution】的数据库操作Service实现
* @createDate 2023-12-01 16:44:14
*/
@Service
public class PrecautionServiceImpl extends ServiceImpl<PrecautionMapper, Precaution>
    implements PrecautionService{

  private static final Logger logger = LoggerFactory.getLogger(PrecautionService.class);

  @Autowired
  UserPrecautionMapper userPrecautionMapper;

  @Autowired
  PrecautionMapper precautionMapper;


  @Override
  public void saveUserAndPrecautions(Integer userId, List<Integer> precautions) {
    for (Integer precaution : precautions) {
      try {
        UserPrecaution userPrecaution = new UserPrecaution();
        userPrecaution.setUserId(userId);
        userPrecaution.setPrecautionId(precaution);
        userPrecautionMapper.insert(userPrecaution);
      } catch (Exception e) {
        logger.error("Error occurred while saving user precaution for user ID " + userId + " and precaution ID " + precaution, e);
      }
    }
  }

  @Override
  public List<Integer> getPrecautionsIDsByUserId(Integer id) {
    try {
      return precautionMapper.getPrecautionsIDsByUserId(id);
    } catch (Exception e) {
      logger.error("Error occurred while fetching precautions for user ID " + id, e);
      return Collections.emptyList();
    }
  }

  @Override
  public List<Precaution> getPrecautionsByUserId(Integer id) {
    try {
      return precautionMapper.getPrecautionsByUserId(id);
    } catch (Exception e) {
      logger.error("Error occurred while fetching precautions for user ID " + id, e);
      return Collections.emptyList();
    }
  }

  @Override
  public List<Precaution> getPrecautionByDiseaseId(Integer diseaseId) {
    try {
      return precautionMapper.getPrecautionByDiseaseId(diseaseId);
    } catch (Exception e) {
      logger.error("Error occurred while fetching precautions for disease ID " + diseaseId, e);
      return Collections.emptyList();
    }
  }

  @Override
  public List<Precaution> getPrecautionByDiseaseName(String diseaseName) {
    try {
      return precautionMapper.getPrecautionByDiseaseName(diseaseName);
    } catch (Exception e) {
      logger.error("Error occurred while fetching precautions for disease named " + diseaseName, e);
      return Collections.emptyList();
    }
  }

  @Override
  public void deletePrecautionsByUserId(Integer id) {
    precautionMapper.deletePrecautionsByUserId(id);
  }
}




