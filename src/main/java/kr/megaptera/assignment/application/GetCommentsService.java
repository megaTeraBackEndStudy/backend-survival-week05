package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentResponseDto;
import kr.megaptera.assignment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCommentsService {
  private final CommentRepository commentRepository;

  public List<CommentResponseDto> getCommentList(String postId) {
      return commentRepository.findAll(postId).stream().map(CommentResponseDto::of).toList();
  }

}
