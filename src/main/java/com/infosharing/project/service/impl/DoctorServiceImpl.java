package com.infosharing.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infosharing.project.pojo.Doctor;
import com.infosharing.project.service.DoctorService;
import com.infosharing.project.mapper.DoctorMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
* @author Quanle
* @description 针对表【doctor】的数据库操作Service实现
* @createDate 2023-12-01 20:43:04
*/
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor>
    implements DoctorService{

  private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

  @Autowired
  DoctorMapper doctorMapper;

  @Override
  public List<Doctor> listAll() {
    try {
      return doctorMapper.getAllDoctors();
    } catch (Exception e) {
      logger.error("Error occurred while fetching the list of doctors", e);
      return Collections.emptyList();
    }
  }

  @Override
  public int insertOneDoctor(Doctor doctor) {
    try {
      return doctorMapper.insertOneDoctor(doctor);
    } catch (Exception e) {
      logger.error("Error occurred while inserting a doctor: " + doctor, e);
      return -1; // Example: returning -1 to indicate an error
    }
  }

  @Override
  public List<Doctor> getDoctorsByHospitalId(Integer hospitalId) {
    return doctorMapper.getDoctorsByHospitalId(hospitalId);
  }
}




