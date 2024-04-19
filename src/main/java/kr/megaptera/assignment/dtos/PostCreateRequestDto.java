package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostCreateRequestDto {
  private String title;
  private String content;
  private String author;

  public Post toEntity(){
    return new Post(null,title,content,author);
  }
}
