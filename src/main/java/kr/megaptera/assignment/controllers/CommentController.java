package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CreateCommentService;
import kr.megaptera.assignment.application.DeleteCommentService;
import kr.megaptera.assignment.application.GetCommentsService;
import kr.megaptera.assignment.application.UpdateCommentService;
import kr.megaptera.assignment.dtos.CommentCreateRequestDto;
import kr.megaptera.assignment.dtos.CommentResponseDto;
import kr.megaptera.assignment.dtos.CommentUpdateRequestDto;
import kr.megaptera.assignment.exceptions.CommentNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
  private final GetCommentsService getCommentsService;
  private final CreateCommentService createCommentService;
  private final UpdateCommentService updateCommentService;
  private final DeleteCommentService deleteCommentService;
  @GetMapping
  public List<CommentResponseDto> detail(@RequestParam String postId) {
    return getCommentsService.getCommentList(postId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CommentResponseDto create(@RequestParam String postId,
      @RequestBody CommentCreateRequestDto request) {
    request.setPostId(postId);
    return createCommentService.createComment(request);

  }

  @PatchMapping("/{id}")
  public CommentResponseDto update(@PathVariable String id,
      @RequestBody CommentUpdateRequestDto commentUpdateDto) {
    return updateCommentService.update(id, commentUpdateDto);

  }

  @DeleteMapping("/{id}")
  public CommentResponseDto delete(@PathVariable String id) {
    return deleteCommentService.deleteComment(id);
  }


  @ExceptionHandler(CommentNotFound.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String postNotFound() {
    return "댓글을 찾을 수 없습니다.";
  }
}
