package com.microservices.comment.repository;

import com.microservices.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,String> {
    List<Comment> findByPostId(String postId);
    //by writing this custom method this abstract method will automatically convert
    //   into HQL query automatically, hibernate and spring-boot does this.
}
