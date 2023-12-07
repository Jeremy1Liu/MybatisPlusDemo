package com.atguigu.mybatisplusdemo.controller;

import com.atguigu.mybatisplusdemo.pojo.Blog;
import com.atguigu.mybatisplusdemo.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.List;

@RestController
public class BlogController {

  @Autowired
  BlogService blogService;

  @GetMapping("/blogs")
  public List<Blog> getAllBlogs() {
    return blogService.list();
  }

  @GetMapping("/blog/{id}")
  public Blog getBlogById(@PathVariable Integer id) {
    return blogService.getById(id);
  }

  @PostMapping("/blog")
  public boolean createBlog(@RequestBody Blog blog) {
    return blogService.addBlog(blog);
  }

  @PutMapping("/blog")
  public boolean updateBlog(@RequestBody Blog blog) {
    return blogService.updateById(blog);
  }

  // filter the blogs by user id
  @GetMapping("/blogs/userId/{userId}")
  public List<Blog> getBlogByUserId(@PathVariable Integer userId) {
    // filter blogs by userId
    // return blogs list

    return blogService.getBlogByUserId(userId);
  }

  @DeleteMapping("/blog/{blogId}")
  public void deleteBlogById(@PathVariable Integer blogId) {
    blogService.deleteBlogById(blogId);
  }




}
