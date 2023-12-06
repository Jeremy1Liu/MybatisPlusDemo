package com.atguigu.mybatisplusdemo.controller;

import com.atguigu.mybatisplusdemo.pojo.Comments;
import com.atguigu.mybatisplusdemo.service.CommentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

  @Autowired
  CommentsService commentsService;

  @GetMapping("/comments")
  public List<Comments> getAllComments() {
    return commentsService.list();
  }

  @GetMapping("/comment/{id}")
  public Comments getCommentById(Integer id) {
    return commentsService.getById(id);
  }

  @GetMapping("/comment/blog/{blogId}")
  public List<Comments> getCommentByBlogId(Integer blogId) {
    return commentsService.getCommentByBlogId(blogId);
  }

  @PostMapping("/comment")
  public boolean addComment(@RequestBody Comments comment) {
    return commentsService.save(comment);
  }

  @DeleteMapping("/comment/{id}")
  public boolean deleteCommentById(Integer id) {
    return commentsService.removeById(id);
  }

}
