package com.jaeho.buskers.web;

import com.jaeho.buskers.domain.posts.Posts;
import com.jaeho.buskers.domain.posts.PostsRepository;
import com.jaeho.buskers.web.dto.PostsSaveRequestDto;
import com.jaeho.buskers.web.dto.PostsUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsAipControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void tearDown() {
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_save() {
        // given
        String title = "title";
        String content = "content";
        String address = "address";
        LocalDateTime startDateTime = LocalDateTime.of(2022, 11, 27, 15, 0);
        LocalDateTime endDateTime = LocalDateTime.of(2022, 11, 27, 16, 0);

        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title(title)
                .content(content)
                .address(address)
                .startDateTime(startDateTime)
                .endDateTime(endDateTime)
                .author("author").build();

        String url = "http://localhost:" + port + "/api/v1/posts";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
        assertThat(all.get(0).getStartDateTime()).isEqualTo(startDateTime);
        assertThat(all.get(0).getEndDateTime()).isEqualTo(endDateTime);
        assertThat(all.get(0).getAddress()).isEqualTo(address);
        assertThat(all.get(0).getAuthor()).isEqualTo("author");

    }

    @Test
    public void Posts_update() {
        // given
        Posts savedPost = postsRepository.save(Posts.builder()
                        .title("title")
                        .author("author")
                        .startDateTime(LocalDateTime.of(2022, 11, 27, 15, 0))
                        .endDateTime(LocalDateTime.of(2022, 11, 27, 16, 0))
                        .address("address")
                        .content("content")
                        .build());

        Long updateId = savedPost.getId();
        String expectedTitle = "title2";
        String expectedAddress = "address2";
        String expectedContent = "content2";
        LocalDateTime expectedStartDateTime = LocalDateTime.of(2022,12,27,15,0);
        LocalDateTime expectedEndDateTime = LocalDateTime.of(2022,12,27,16,0);

        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
                .title(expectedTitle)
                .startDateTime(expectedStartDateTime)
                .endDateTime(expectedEndDateTime)
                .content(expectedContent)
                .address(expectedAddress)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;

        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        // when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getStartDateTime()).isEqualTo(expectedStartDateTime);
        assertThat(all.get(0).getEndDateTime()).isEqualTo(expectedEndDateTime);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
        assertThat(all.get(0).getAddress()).isEqualTo(expectedAddress);
    }

}
