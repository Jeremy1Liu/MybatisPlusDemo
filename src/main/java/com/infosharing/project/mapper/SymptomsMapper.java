package com.infosharing.project.mapper;

import com.infosharing.project.pojo.Symptoms;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author Quanle
 * @description 针对表【symptoms】的数据库操作Mapper
 * @createDate 2023-12-01 18:02:57
 * @Entity com.atguigu.mybatisplusdemo.pojo.Symptoms
 */
public interface SymptomsMapper extends BaseMapper<Symptoms> {

    List<Symptoms> getSymptomsByUserId(Integer id);

    List<Integer> getSymptomsIDsByUserId(Integer id);

    List<Symptoms> getSymptomsByDiseaseId(Integer diseaseId);

    List<Symptoms> getSymptomsByDiseaseName(String diseaseName);

    void deleteSymptomsByUserId(Integer userId);

}




