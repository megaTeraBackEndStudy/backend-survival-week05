package kr.megaptera.assignment.application;

import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.repository.CommentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class GetCommentsServiceTest {
  @Autowired
  private GetCommentsService getCommentsService;

  @MockBean
  private CommentRepository commentRepository;

  @DisplayName("댓글 목록 조회")
  @Test
  public void getDetail() throws Exception {
    //given
    String postId = "1234";
    given(commentRepository.findAll(postId)).willReturn(
        List.of(new Comment("001", postId, "content", "author"),
            new Comment("002", postId, "content2", "author2")));
    //when
    var commentList = getCommentsService.getCommentList(postId);
    //then
    assertThat(commentList).hasSize(2);
  }


}
