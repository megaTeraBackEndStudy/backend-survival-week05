package kr.megaptera.assignment.repository;

import kr.megaptera.assignment.exceptions.CommentNotFound;
import kr.megaptera.assignment.models.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CommentRepository {
  private final Map<String, Comment> commentMap = new HashMap<>();

  public List<Comment> findAll(String postId) {
    return commentMap.values().stream().filter(comment -> comment.getPostId().equals(postId))
        .toList();
  }

  public Comment save(Comment comment){
    commentMap.put(comment.getId(),comment);
    return comment;
  }


  public Comment find(String id) {
    var comment = commentMap.get(id);
    if(comment == null){
      throw new CommentNotFound();
    }
    return comment;
  }

  public Comment delete(String commentId) {
    var comment = find(commentId);
    commentMap.remove(commentId);
    return comment;
  }
}
