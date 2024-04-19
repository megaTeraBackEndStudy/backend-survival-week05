package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentResponseDto;
import kr.megaptera.assignment.dtos.CommentUpdateRequestDto;
import kr.megaptera.assignment.dtos.RequestUpdate;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCommentService {
  private final CommentRepository commentRepository;

  public CommentResponseDto update(String commentId, RequestUpdate<Comment> request) {
    var comment = commentRepository.find(commentId);
    request.update(comment);
    return CommentResponseDto.of(commentRepository.save(comment));
  }
}
