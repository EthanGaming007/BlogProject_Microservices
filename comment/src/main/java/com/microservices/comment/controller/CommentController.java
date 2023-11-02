package com.microservices.comment.controller;

import com.microservices.comment.entity.Comment;
import com.microservices.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;
    //http://localhost:8082/api/comments
    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment){
        Comment savedComment = commentService.saveComment(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.OK);
    }
    @GetMapping("/{postId}")
    public List<Comment> getAllCommentsByPostId(@PathVariable String postId){
       List<Comment> comments = commentService.getAllCommentsByPostId(postId);
       return comments;
    }

}
// upper link will call savecomment method and it will call comment service.
//comment controller will trigger that action
//comment controller is calling service layer and service layer is calling post controller using rest template object
//post controller is taking the post id if object founds the rest template gets that object into the comment.
//and the comment will have the comment id