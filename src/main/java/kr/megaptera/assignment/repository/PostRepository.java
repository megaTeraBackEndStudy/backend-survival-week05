package kr.megaptera.assignment.repository;

import kr.megaptera.assignment.dtos.PostResponseDto;
import kr.megaptera.assignment.exceptions.PostNotFound;
import kr.megaptera.assignment.models.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepository {
  private final Map<String, Post> postMap = new HashMap<>();

  public Post save(Post post) {
    postMap.put(post.getId(),post);
    return postMap.get(post.getId());
  }

  public List<Post> findAll(){
    return postMap.values().stream().toList();
  }
  public Post findPostById(String id){
    Post post = postMap.get(id);
    if(post == null){
      throw new PostNotFound();
    }
      return post;
  }

  public Post delete(String id) {
    var post = findPostById(id);
    postMap.remove(post.getId());
    return post;
  }
}
