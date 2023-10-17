package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Dto.PostDto;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_index")
    int postIndex;
    @Column(name = "mem_id")
    String memId;
    String title;
    String content;
    int like;
    @Column(name = "post_date")
    Date postDate;

    public PostDto toDto() {
        return PostDto.builder()
                .postIndex(postIndex)
                .memId(memId)
                .title(title)
                .content(content)
                .like(like)
                .postDate(postDate)
                .build();
    }
}
