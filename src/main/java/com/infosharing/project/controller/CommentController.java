package com.infosharing.project.controller;

import com.infosharing.project.pojo.Comments;
import com.infosharing.project.service.CommentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
  public Comments getCommentById(@PathVariable Integer id) {
    return commentsService.getById(id);
  }

  @GetMapping("/comment/blog/{blogId}")
  public List<Comments> getCommentByBlogId(@PathVariable("blogId") Integer blogId) {
    return commentsService.getCommentByBlogId(blogId);
  }

  @PostMapping("/comment")
  public int addComment(@RequestBody Comments comment) {
    return commentsService.insertOneComment(comment);
  }

  @DeleteMapping("/comment/{id}")
  public boolean deleteCommentById(@PathVariable Integer id) {
    return commentsService.removeById(id);
  }

}
