package kr.megaptera.assignment.application;

import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
class DeletePostServiceTest {
    @Autowired
    private DeletePostService postService;

    @MockBean
    private PostRepository postRepository;

    @Test
    @DisplayName("게시물 삭제")
    void delete() {
        String postId = "1234";
        Post post = new Post(postId,"제목","작성자","내용");
        given(postRepository.findPostById(postId)).willReturn(post);
        given(postRepository.delete(postId)).willReturn(post);

        postService.deletePost(postId);

        verify(postRepository).delete(any(String.class));
    }
}
