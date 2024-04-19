package kr.megaptera.assignment.models;

import lombok.Getter;

@Getter
public class Comment extends BaseEntity {

  private String postId;
  private String author;
  private String content;

  public Comment(final String id, final String postId, final String author, final String content) {
    super(id);
    this.author = author;
    this.content = content;
  }

  public void update(String content){
    this.content = content;
  }

}
