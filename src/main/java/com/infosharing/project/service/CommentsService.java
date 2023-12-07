package com.infosharing.project.service;

import com.infosharing.project.pojo.Comments;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Quanle
* @description 针对表【comments】的数据库操作Service
* @createDate 2023-12-01 14:55:32
*/
public interface CommentsService extends IService<Comments> {

  List<Comments> getCommentByBlogId(Integer blogId);

  int insertOneComment(Comments comment);
}
