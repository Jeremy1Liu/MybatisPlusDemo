package com.atguigu.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mybatisplusdemo.pojo.Disease;
import com.atguigu.mybatisplusdemo.service.DiseaseService;
import com.atguigu.mybatisplusdemo.mapper.DiseaseMapper;
import org.springframework.stereotype.Service;

/**
* @author Quanle
* @description 针对表【disease】的数据库操作Service实现
* @createDate 2023-11-30 14:07:23
*/
@Service
public class DiseaseServiceImpl extends ServiceImpl<DiseaseMapper, Disease>
    implements DiseaseService{

}




