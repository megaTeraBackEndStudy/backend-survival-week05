package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentCreateRequestDto;
import kr.megaptera.assignment.dtos.CommentResponseDto;
import kr.megaptera.assignment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCommentService {
  private final CommentRepository commentRepository;

  public CommentResponseDto createComment(CommentCreateRequestDto request){
    return CommentResponseDto.of(commentRepository.save(request.toEntity()));
  }
}

