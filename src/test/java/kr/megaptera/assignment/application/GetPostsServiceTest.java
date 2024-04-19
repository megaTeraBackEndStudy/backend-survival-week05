package kr.megaptera.assignment.application;

import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class GetPostsServiceTest {
    @Autowired
    private GetPostService getPostService;
    @MockBean
    private PostRepository postRepository;
    @Test
    @DisplayName("게시물 목록 조회")
    void list() {
        given(postRepository.findAll())
            .willReturn(
                List.of(new Post(null,"제목","작성자","내용"),new Post(null,"제목2","작성자2","내용2")));
        var posts = getPostService.getList();

        assertThat(posts).hasSize(2);
    }
}
