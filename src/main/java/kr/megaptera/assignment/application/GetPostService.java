package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostResponseDto;
import kr.megaptera.assignment.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPostService {
  private final PostRepository postRepository;
  public List<PostResponseDto> getList() {
    return postRepository.findAll().stream().map(PostResponseDto::of).toList();
  }

  public PostResponseDto detail(String id) {
    return PostResponseDto.of(postRepository.findPostById(id));
  }
}
