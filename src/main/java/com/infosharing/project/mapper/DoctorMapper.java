package com.infosharing.project.mapper;

import com.infosharing.project.pojo.Doctor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author Quanle
 * @description 针对表【doctor】的数据库操作Mapper
 * @createDate 2023-12-01 20:43:04 @Entity com.atguigu.mybatisplusdemo.pojo.Doctor
 */
public interface DoctorMapper extends BaseMapper<Doctor> {

  int insertOneDoctor(Doctor doctor);

  List<Doctor> getAllDoctors();

  List<Doctor> getDoctorsByHospitalId(Integer hospitalId);
}
