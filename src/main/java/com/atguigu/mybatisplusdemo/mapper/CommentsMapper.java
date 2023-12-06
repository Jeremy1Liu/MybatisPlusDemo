package com.atguigu.mybatisplusdemo.mapper;

import com.atguigu.mybatisplusdemo.pojo.Comments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Quanle
* @description 针对表【comments】的数据库操作Mapper
* @createDate 2023-12-01 14:55:32
* @Entity com.atguigu.mybatisplusdemo.pojo.Comments
*/
public interface CommentsMapper extends BaseMapper<Comments> {

  List<Comments> getCommentByBlogId(Integer blogId);

  int insertOneComment(Comments comment);
}




