package com.infosharing.project.mapper;
import org.apache.ibatis.annotations.Param;

import com.infosharing.project.pojo.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Quanle
* @description 针对表【blog】的数据库操作Mapper
* @createDate 2023-11-30 16:46:10
* @Entity com.atguigu.mybatisplusdemo.pojo.Blog
*/
public interface BlogMapper extends BaseMapper<Blog> {


  List<Blog> getAllByUserId(@Param("userId") Integer userId);

  int insertBlog(Blog blog);
}




