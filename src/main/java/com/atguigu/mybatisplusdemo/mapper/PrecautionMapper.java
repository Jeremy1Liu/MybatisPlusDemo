package com.atguigu.mybatisplusdemo.mapper;

import com.atguigu.mybatisplusdemo.pojo.Precaution;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Quanle
* @description 针对表【precaution】的数据库操作Mapper
* @createDate 2023-12-01 16:44:14
* @Entity com.atguigu.mybatisplusdemo.pojo.Precaution
*/
public interface PrecautionMapper extends BaseMapper<Precaution> {

  List<Precaution> selectByUserId(@Param("userId") Integer userId);

}




