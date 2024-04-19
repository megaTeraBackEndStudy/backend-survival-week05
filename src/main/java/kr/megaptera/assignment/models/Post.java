package kr.megaptera.assignment.models;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Post extends BaseEntity {

  private String title;
  private final String author;
  private String content;


  @Builder
  public Post(final String id,final String title, final String content, final String author) {
    super(id);
    this.title = title;
    this.content = content;
    this.author = author;
  }

  public void update(final String title, final String content) {
    this.title = title;
    this.content = content;
  }

}
