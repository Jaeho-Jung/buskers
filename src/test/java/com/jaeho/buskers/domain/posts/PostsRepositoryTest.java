package com.jaeho.buskers.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_saveLoad() {
        // given
        String title = "title";
        String author = "author";
        LocalDateTime startTime = LocalDateTime.of(2022, 11, 27, 15, 0);
        LocalDateTime endTime = LocalDateTime.of(2022, 11, 27, 16, 0);
        String address = "address";
        String content = "content";

        postsRepository.save(Posts.builder()
                        .title(title)
                        .author(author)
                        .startTime(startTime)
                        .endTime(endTime)
                        .address(address)
                        .content(content)
                        .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getAuthor()).isEqualTo(author);
        assertThat(posts.getStartTime()).isEqualTo(startTime);
        assertThat(posts.getEndTime()).isEqualTo(endTime);
        assertThat(posts.getAddress()).isEqualTo(address);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
