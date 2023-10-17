package com.STC.StudyCode.Dto;

import lombok.*;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PostDto {

    int postIndex;
    String memId;
    String title;
    String content;
    int like;
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
