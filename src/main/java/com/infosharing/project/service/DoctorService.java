package com.infosharing.project.service;

import com.infosharing.project.pojo.Doctor;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Quanle
* @description 针对表【doctor】的数据库操作Service
* @createDate 2023-12-01 20:43:04
*/
public interface DoctorService extends IService<Doctor> {

  List<Doctor> listAll();

    int insertOneDoctor(Doctor doctor);

  List<Doctor> getDoctorsByHospitalId(Integer hospitalId);
}
