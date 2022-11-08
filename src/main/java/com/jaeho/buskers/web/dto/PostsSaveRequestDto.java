package com.jaeho.buskers.web.dto;


import com.jaeho.buskers.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String author;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String address;
    private String content;

    @Builder
    public PostsSaveRequestDto(String title, String author, LocalDateTime startTime, LocalDateTime endTime, String address, String content) {
        this.title = title;
        this.author = author;
        this.startTime = startTime;
        this.endTime = endTime;
        this.address = address;
        this.content = content;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .author(author)
                .startTime(startTime)
                .endTime(endTime)
                .address(address)
                .content(content).build();
    }
}
