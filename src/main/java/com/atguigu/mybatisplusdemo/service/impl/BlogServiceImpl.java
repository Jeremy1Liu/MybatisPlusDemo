package com.atguigu.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mybatisplusdemo.pojo.Blog;
import com.atguigu.mybatisplusdemo.service.BlogService;
import com.atguigu.mybatisplusdemo.mapper.BlogMapper;

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
    return false;
  }
}




