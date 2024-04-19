package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentUpdateRequestDto implements RequestUpdate<Comment> {
  private String content;

  @Override
  public void update(Comment entity) {
      entity.update(content);
  }
}
