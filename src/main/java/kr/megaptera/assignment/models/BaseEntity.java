package kr.megaptera.assignment.models;

import lombok.Getter;

import java.util.UUID;

@Getter
public class BaseEntity {
  protected String id;

  public BaseEntity(final String id) {
    if(id == null){
      this.id = UUID.randomUUID().toString();
      return;
    }
    this.id = id;
  }

}
