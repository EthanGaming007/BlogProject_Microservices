package com.microservices.comment.service;

import com.microservices.comment.config.RestTemplateConfig;
import com.microservices.comment.entity.Comment;
import com.microservices.comment.payload.Post;
import com.microservices.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;


@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private RestTemplateConfig restTemplate;

    public Comment saveComment(Comment comment) {
        //Here we have to check whether post exists or not before saving comment.how we do this lets see,
        // Here we have to interact with the post Microservices.we have to make it to interact with the post-id url,
        //this is where we do rest template class.

        Post post = restTemplate.getRestTemplate().getForObject("http://POST-SERVICE/api/posts/" + comment.getPostId(), Post.class);
        //this line of code will go to url based on the post-id it will get the post object and post object content u stored
        // it in the post object;through this post object we are storing the content.if post object is null then post will not exist and
        //if post object is not null then post will exists. Post.class is that what url is returning we have to mention that .
        if (post != null) {
            String commentId = UUID.randomUUID().toString();
            comment.setCommentId(commentId);
            Comment savedComment = commentRepository.save(comment);
        } else {
            return null;
        }
        return comment;
    }
    public List<Comment> getAllCommentsByPostId(String postId) {
        List<Comment> comments = commentRepository.findByPostId(postId); //it will search all the comments based on the postId and
        return comments;                                                 //list of comments will go to the controller
    }
    //based on the post id we cannot get the comment but based on the comment id I can get the comment ,
    //I have no built-in methods for this method of getting comments through post id ,
    //in such cases we have to built owm custom methods in repository layer
}
