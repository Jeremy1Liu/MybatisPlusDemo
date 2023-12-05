package com.atguigu.mybatisplusdemo.service.impl;

import com.atguigu.mybatisplusdemo.mapper.UserPrecautionMapper;
import com.atguigu.mybatisplusdemo.pojo.UserPrecaution;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mybatisplusdemo.pojo.Precaution;
import com.atguigu.mybatisplusdemo.service.PrecautionService;
import com.atguigu.mybatisplusdemo.mapper.PrecautionMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Quanle
* @description 针对表【precaution】的数据库操作Service实现
* @createDate 2023-12-01 16:44:14
*/
@Service
public class PrecautionServiceImpl extends ServiceImpl<PrecautionMapper, Precaution>
    implements PrecautionService{

  @Autowired
  UserPrecautionMapper userPrecautionMapper;

  @Autowired
  PrecautionMapper precautionMapper;


  @Override
  public void saveUserAndPrecautions(Integer userId, List<Precaution> precautions) {
    for (Precaution precaution : precautions) {
      // save user precaution
      UserPrecaution userPrecaution = new UserPrecaution();
      userPrecaution.setUserId(userId);
      userPrecaution.setPrecautionId(precaution.getId());
      userPrecautionMapper.insert(userPrecaution);
    }
  }

  @Override
  public List<Precaution> getPrecautionsByUserId(Integer id) {
    List<Precaution> precautions = precautionMapper.getPrecautionsByUserId(id);
    return precautions;
  }

  @Override
  public List<Precaution> getPrecautionByDiseaseId(Integer diseaseId) {
    List<Precaution> precautions = precautionMapper.getPrecautionByDiseaseId(diseaseId);
    return precautions;
  }

  @Override
  public List<Precaution> getPrecautionByDiseaseName(String diseaseName) {
    List<Precaution> precautions = precautionMapper.getPrecautionByDiseaseName(diseaseName);
    return precautions;
  }
}




