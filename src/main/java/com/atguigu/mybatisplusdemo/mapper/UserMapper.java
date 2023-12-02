package com.atguigu.mybatisplusdemo.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.atguigu.mybatisplusdemo.pojo.Hospital;
import com.atguigu.mybatisplusdemo.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Quanle
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-11-30 15:12:13
* @Entity com.atguigu.mybatisplusdemo.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {

  int callCreateUserProcedure(String p_name, String p_email, int p_age, String p_gender);



  int insertAll(User user);

  List<User> getById(@Param("id") Integer id);


  //id, name, email, age, gender, hospital_id, hospital_name, disease_id, disease_name
  @Select("select * from user")
  @Results(
          {
                  @Result(column = "id", property = "id"),
                  @Result(column = "name", property = "name"),
                  @Result(column = "email", property = "email"),
                  @Result(column = "age", property = "age"),
                  @Result(column = "gender", property = "gender"),
                  @Result(column = "hospital_id", property = "hospitalId"),
                  @Result(column = "disease_id", property = "diseaseId"),
                  @Result(column = "hospital_id", property = "hospital", javaType = Hospital.class,
                          one = @One(select = "com.atguigu.mybatisplusdemo.mapper.HospitalMapper.selectById")),
                  @Result(column = "id", property = "precautions", javaType = List.class,
                          many = @Many(select = "com.atguigu.mybatisplusdemo.mapper.PrecautionMapper.selectByUserId"))
          }
  )
  List<User> selectAllUserWithHospital();

  int deleteById(@Param("id") Integer id);

  int deleteByAgeAndGenderStartWith(@Param("age") Integer age, @Param("gender") String gender);

  int addAll(User user);

}




