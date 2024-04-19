package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostCreateRequestDto;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
class CreatePostServiceTest {
    @Autowired
    private CreatePostService createPostService;
    @SpyBean
    PostRepository postRepository;


    @Test
    @DisplayName("게시물 생성")
    void create() {
        var post = createPostService.createPost(new PostCreateRequestDto("제목","작성자","내용"));

        assertThat(post.getTitle()).isEqualTo("제목");
        assertThat(post.getContent()).isEqualTo("작성자");
        assertThat(post.getAuthor()).isEqualTo("내용");

        verify(postRepository).save(any(Post.class));
    }
}
