package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentResponseDto;
import kr.megaptera.assignment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCommentService {
  private final CommentRepository commentRepository;
  public CommentResponseDto deleteComment(String commentId) {
    return CommentResponseDto.of(commentRepository.delete(commentId));
  }
}
