package com.atguigu.mybatisplusdemo.service;

import com.atguigu.mybatisplusdemo.pojo.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Quanle
* @description 针对表【blog】的数据库操作Service
* @createDate 2023-11-30 16:46:10
*/
public interface BlogService extends IService<Blog> {

  List<Blog> getBlogByUserId(Integer userId);

  boolean addBlog(Blog blog);

    void deleteBlogById(Integer blogId);
}
