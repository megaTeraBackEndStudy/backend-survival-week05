package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostResponseDto;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class GetPostServiceTest {
    @Autowired
    GetPostService getPostService;
    @MockBean
    private PostRepository postRepository;
    @Test
    @DisplayName("게시물 조회")
    void detail() {
        //given
        String searchId = "001test";
        given(postRepository.findPostById(searchId)).willReturn(new Post(
            searchId,
            "제목",
            "작성자",
            "내용"
        ));
        //when
        var post = getPostService.detail(searchId);
        //then
        assertThat(post.getTitle()).isEqualTo("제목");
        assertThat(post.getContent()).isEqualTo("작성자");
        assertThat(post.getAuthor()).isEqualTo("내용");


    }
}
