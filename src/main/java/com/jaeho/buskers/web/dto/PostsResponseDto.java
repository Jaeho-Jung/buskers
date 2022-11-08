package com.jaeho.buskers.web.dto;

import com.jaeho.buskers.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String address;
    private String content;

    public PostsResponseDto(Posts entity) {
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.startTime = entity.getStartTime();
        this.endTime = entity.getStartTime();
        this.address = entity.getAddress();
        this.content = entity.getContent();
    }
}
