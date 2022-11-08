package com.jaeho.buskers.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsUpdateRequestDto {

    private String title;
    private String content;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String address;

    @Builder
    public PostsUpdateRequestDto(String title, String content, LocalDateTime startTime, LocalDateTime endTime, String address) {
        this.title = title;
        this.content = content;
        this.startTime = startTime;
        this.endTime = endTime;
        this.address = address;
    }
}
