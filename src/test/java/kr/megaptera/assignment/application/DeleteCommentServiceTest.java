package kr.megaptera.assignment.application;

import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.repository.CommentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
class DeleteCommentServiceTest {
  @Autowired
  private DeleteCommentService deleteCommentService;
  @MockBean
  private CommentRepository commentRepository;


  @DisplayName("댓글 삭제")
  @Test
  public void delete() throws Exception {
    //given
    String commentId = "1234";
    Comment comment = new Comment(commentId, "1234", "작성자", "내용");
    //when
    given(commentRepository.find(commentId)).willReturn(comment);
    given(commentRepository.delete(commentId)).willReturn(comment);
    //then
    deleteCommentService.deleteComment(commentId);

    verify(commentRepository).delete(any(String.class));
  }
}
