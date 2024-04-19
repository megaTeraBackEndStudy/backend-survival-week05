package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentResponseDto {
  private String id;
  private String author;
  private String content;

  public static CommentResponseDto of(Comment comment){
    return new CommentResponseDto(comment.getId(),comment.getAuthor(),comment.getContent());
  }

}
