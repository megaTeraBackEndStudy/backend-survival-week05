package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
  private String id;
  private String title;
  private String author;
  private String content;

  public PostResponseDto(String id, String title, String author, String content) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.content = content;
  }

  public static PostResponseDto of(Post post){
    return new PostResponseDto(post.getId(),post.getTitle(),post.getAuthor(),post.getContent());
  }
}
