package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostResponseDto;
import kr.megaptera.assignment.dtos.RequestUpdate;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePostService {
  private final PostRepository postRepository;

  public PostResponseDto updatePost(String id,RequestUpdate<Post> request){
    var post = postRepository.findPostById(id);
    request.update(post);
    return PostResponseDto.of(postRepository.save(post));
  }

}
