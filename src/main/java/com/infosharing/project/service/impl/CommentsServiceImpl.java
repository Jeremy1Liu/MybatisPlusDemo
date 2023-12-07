package com.infosharing.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infosharing.project.pojo.Comments;
import com.infosharing.project.service.CommentsService;
import com.infosharing.project.mapper.CommentsMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


/**
* @author Quanle
* @description 针对表【comments】的数据库操作Service实现
* @createDate 2023-12-01 14:55:32
*/
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments>
    implements CommentsService{

  private static final Logger logger = LoggerFactory.getLogger(CommentsServiceImpl.class);

  @Autowired
  CommentsMapper commentsMapper;
  @Override
  public List<Comments> getCommentByBlogId(Integer blogId) {
    try {
      List<Comments> comments = commentsMapper.getCommentByBlogId(blogId);
      return comments;
    } catch (Exception e) {
      // Log the exception
      logger.error("Error occurred while fetching comments for blog ID " + blogId, e);
      return Collections.emptyList();
    }
  }

  @Override
  public int insertOneComment(Comments comment) {
    try {
      return commentsMapper.insertOneComment(comment);
    } catch (Exception e) {
      logger.error("Error occurred while adding a comment: " + comment, e);
      return -1; // Example: returning -1 to indicate an error
    }
  }
}




