package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentCreateRequestDto {
  private String postId;
  private String author;
  private String content;

  public Comment toEntity(){
    return new Comment(null,postId,author,content);
  }

  public void setPostId(String postId) {
    this.postId = postId;
  }
}
