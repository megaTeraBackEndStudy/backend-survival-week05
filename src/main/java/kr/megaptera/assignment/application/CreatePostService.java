package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostCreateRequestDto;
import kr.megaptera.assignment.dtos.PostResponseDto;
import kr.megaptera.assignment.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePostService {
  private final PostRepository postRepository;
  public PostResponseDto createPost(PostCreateRequestDto request) {
    var post = postRepository.save(request.toEntity());
      return PostResponseDto.of(post);
  }
}
