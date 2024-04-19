package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostResponseDto;
import kr.megaptera.assignment.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePostService {
  private final PostRepository postRepository;
  public PostResponseDto deletePost(String id) {
     return PostResponseDto.of(postRepository.delete(id));
  }
}
