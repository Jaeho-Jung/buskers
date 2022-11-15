package com.jaeho.buskers.domain.posts;

import com.jaeho.buskers.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
 * 게시글
 *  - 제목
 *  - 작성자
 *  - 일시
 *  - 장소
 *  - 내용
*/

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    private String author;

    @Column(nullable = false)
    private LocalDateTime startDateTime;

    @Column(nullable = false)
    private LocalDateTime endDateTime;

    @Column(nullable = false)
    private String address;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Builder
    public Posts(String title, String author, LocalDateTime startDateTime, LocalDateTime endDateTime, String address, String content) {
        this.title = title;
        this.author = author;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.address = address;
        this.content = content;
    }

    public void update(String title, LocalDateTime startDateTime, LocalDateTime endDateTime, String address, String content) {
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.address = address;
        this.content = content;
    }
}
