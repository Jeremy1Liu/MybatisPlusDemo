package com.infosharing.project.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.infosharing.project.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Quanle
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-11-30 15:12:13
* @Entity com.atguigu.mybatisplusdemo.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {




  //id, name, email, age, gender, disease_id, disease_name
  @Select("select * from user")
  @Results(
          {
                  @Result(column = "id", property = "id"),
                  @Result(column = "name", property = "name"),
                  @Result(column = "email", property = "email"),
                  @Result(column = "age", property = "age"),
                  @Result(column = "gender", property = "gender"),
                  @Result(column = "disease_id", property = "diseaseId"),
                  @Result(column = "id", property = "precautions", javaType = List.class,
                          many = @Many(select = "com.atguigu.mybatisplusdemo.mapper.PrecautionMapper.selectByUserId"))
          }
  )
  List<User> selectAllUserWithHospital();


}




