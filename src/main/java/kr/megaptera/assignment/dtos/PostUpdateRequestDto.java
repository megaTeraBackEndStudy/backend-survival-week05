package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostUpdateRequestDto implements RequestUpdate<Post> {
  String title;
  String content;

  @Override
  public void update(Post post) {
    post.update(title,content);
  }
}
