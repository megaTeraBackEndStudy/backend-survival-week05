package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentUpdateRequestDto;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.repository.CommentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.BDDMockito.given;

@SpringBootTest
class UpdateCommentServiceTest {
  @Autowired
  private UpdateCommentService updateCommentService;
  @Autowired
  private CommentRepository commentRepository;


  @DisplayName("댓글 수정")
  @Test
  public void update() throws Exception {
    //given
    String commentId = "1234";
    var comment = new Comment(commentId, "postId", "작성자", "내용");
    CommentUpdateRequestDto request = new CommentUpdateRequestDto("수정");
    commentRepository.save(comment);
    //when
    var commentRes = updateCommentService.update(commentId, request);
    //then
    Assertions.assertThat(commentRes.getContent()).isEqualTo(request.getContent());

  }
}
