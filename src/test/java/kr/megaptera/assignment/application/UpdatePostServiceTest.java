package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostUpdateRequestDto;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
class UpdatePostServiceTest {

    @Autowired
    private UpdatePostService postService;

    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("게시물 수정")
    void update() {
        String postId = "1234";
        Post post = new Post(postId,"제목","내용","작성자");
        postRepository.save(post);

        PostUpdateRequestDto updateRequestDto = new PostUpdateRequestDto("수정제목","수정내용");
        postService.updatePost(postId,updateRequestDto);

        assertThat(post.getTitle()).isEqualTo("수정제목");
        assertThat(post.getContent()).isEqualTo("수정내용");

    }
}
