package com.atguigu.mybatisplusdemo.service;

import com.atguigu.mybatisplusdemo.pojo.Precaution;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Quanle
* @description 针对表【precaution】的数据库操作Service
* @createDate 2023-12-01 16:44:14
*/
public interface PrecautionService extends IService<Precaution> {

  void saveUserAndPrecautions(Integer id, List<Precaution> precautions);

  List<Precaution> getPrecautionsByUserId(Integer id);

  List<Precaution> getPrecautionByDiseaseId(Integer diseaseId);

  List<Precaution> getPrecautionByDiseaseName(String diseaseName);
}
