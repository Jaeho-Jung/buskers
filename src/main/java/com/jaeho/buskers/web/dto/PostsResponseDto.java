package com.jaeho.buskers.web.dto;

import com.jaeho.buskers.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String address;
    private String content;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.startDateTime = entity.getStartDateTime();
        this.endDateTime = entity.getStartDateTime();
        this.address = entity.getAddress();
        this.content = entity.getContent();
    }
}
