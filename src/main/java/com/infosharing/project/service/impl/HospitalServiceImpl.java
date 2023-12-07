package com.infosharing.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infosharing.project.pojo.Hospital;
import com.infosharing.project.service.HospitalService;
import com.infosharing.project.mapper.HospitalMapper;

import org.springframework.stereotype.Service;

/**
* @author Quanle
* @description 针对表【hospital】的数据库操作Service实现
* @createDate 2023-12-01 20:46:18
*/
@Service
public class HospitalServiceImpl extends ServiceImpl<HospitalMapper, Hospital>
    implements HospitalService {

}




