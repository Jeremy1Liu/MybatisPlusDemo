package com.infosharing.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infosharing.project.pojo.Disease;
import com.infosharing.project.service.DiseaseService;
import com.infosharing.project.mapper.DiseaseMapper;
import org.springframework.stereotype.Service;

/**
* @author Quanle
* @description 针对表【disease】的数据库操作Service实现
* @createDate 2023-12-01 21:29:09
*/
@Service
public class DiseaseServiceImpl extends ServiceImpl<DiseaseMapper, Disease>
    implements DiseaseService{

}




