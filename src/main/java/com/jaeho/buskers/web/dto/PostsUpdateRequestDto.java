package com.jaeho.buskers.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsUpdateRequestDto {

    private String title;
    private String content;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String address;

    @Builder
    public PostsUpdateRequestDto(String title, String content, LocalDateTime startDateTime, LocalDateTime endDateTime, String address) {
        this.title = title;
        this.content = content;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.address = address;
    }
}
