package com.atguigu.mybatisplusdemo.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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



  int deleteById(@Param("id") Integer id);

  int deleteByAgeAndGenderStartWith(@Param("age") Integer age, @Param("gender") String gender);
}




