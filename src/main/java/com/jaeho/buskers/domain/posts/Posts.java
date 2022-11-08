package com.jaeho.buskers.domain.posts;

import com.jaeho.buskers.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/*https://github.com/Jaeho-Jung/buskers/projects
 * 게시글
 *  - 제목 (not null)
 *  - 작성자
 *  (- 팀원)
 *  - 일시 (not null)
 *  - 장소
 *  - 내용
 *
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
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private String address;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Builder
    public Posts(String title, String author, LocalDateTime startTime, LocalDateTime endTime, String address, String content) {
        this.title = title;
        this.author = author;
        this.startTime = startTime;
        this.endTime = endTime;
        this.address = address;
        this.content = content;
    }

    public void update(String title, LocalDateTime startTime, LocalDateTime endTime, String address, String content) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.address = address;
        this.content = content;
    }
}
