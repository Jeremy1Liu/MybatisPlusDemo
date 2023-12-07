package com.infosharing.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infosharing.project.pojo.Blog;
import com.infosharing.project.service.BlogService;
import com.infosharing.project.mapper.BlogMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Quanle
* @description 针对表【blog】的数据库操作Service实现
* @createDate 2023-11-30 16:46:10
*/
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog>
    implements BlogService{

  @Autowired
  BlogMapper blogMapper;

  @Override
  public List<Blog> getBlogByUserId(Integer userId) {
    List<Blog> blogByUserId = blogMapper.getAllByUserId(userId);

    return blogByUserId;
  }

  @Override
  public boolean addBlog(Blog blog) {
    int insert = blogMapper.insertBlog(blog);
    return insert == 1;
  }

  @Override
  public void deleteBlogById(Integer blogId) {
    blogMapper.deleteById(blogId);
  }
}




