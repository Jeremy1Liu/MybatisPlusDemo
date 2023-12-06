package com.atguigu.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mybatisplusdemo.pojo.Doctor;
import com.atguigu.mybatisplusdemo.service.DoctorService;
import com.atguigu.mybatisplusdemo.mapper.DoctorMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Quanle
* @description 针对表【doctor】的数据库操作Service实现
* @createDate 2023-12-01 20:43:04
*/
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor>
    implements DoctorService{

  @Autowired
  DoctorMapper doctorMapper;

  @Override
  public List<Doctor> listAll() {
    List<Doctor> doctors = doctorMapper.getAllDoctors();
    return doctors;
  }

  @Override
  public int insertOneDoctor(Doctor doctor) {
    return doctorMapper.insertOneDoctor(doctor);
  }
}




