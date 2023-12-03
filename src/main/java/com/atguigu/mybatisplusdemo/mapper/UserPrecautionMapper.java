package com.atguigu.mybatisplusdemo.mapper;

import com.atguigu.mybatisplusdemo.pojo.Precaution;
import com.atguigu.mybatisplusdemo.pojo.UserPrecaution;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Quanle
* @description 针对表【user_precaution】的数据库操作Mapper
* @createDate 2023-12-01 18:27:39
* @Entity com.atguigu.mybatisplusdemo.pojo.UserPrecaution
*/
public interface UserPrecautionMapper extends BaseMapper<UserPrecaution> {

  List<Precaution> getPrecautionsByUserId(Integer id);
}




