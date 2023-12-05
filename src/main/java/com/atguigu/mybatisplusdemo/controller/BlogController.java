package com.atguigu.mybatisplusdemo.controller;

import com.atguigu.mybatisplusdemo.pojo.Blog;
import com.atguigu.mybatisplusdemo.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    return blogService.save(blog);
  }

  @PutMapping("/blog")
  public boolean updateBlog(@RequestBody Blog blog) {
    return blogService.updateById(blog);
  }



}
