package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentCreateRequestDto;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.repository.CommentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
class CreateCommentServiceTest {
  @Autowired
  private CreateCommentService createCommentService;
  @SpyBean
  private CommentRepository commentRepository;


  @DisplayName("")
  @Test
  public void createComment () throws Exception {
      //given
      String postId = "1234";
      CommentCreateRequestDto request = new CommentCreateRequestDto(postId,"author","content");
      //when
      var comment = createCommentService.createComment(request);
      //then
      assertThat(comment.getAuthor()).isEqualTo(request.getAuthor());
      assertThat(comment.getContent()).isEqualTo(request.getContent());

      verify(commentRepository).save(any(Comment.class));
  }
}
