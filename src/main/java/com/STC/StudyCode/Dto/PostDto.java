package com.STC.StudyCode.Dto;

import lombok.*;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PostDto {

    private int postIndex;
    private String memId;
    private String categoryName;
    private String title;
    private String content;
    private int like;
    private Date postDate;

    public PostDto toDto() {
        return PostDto.builder()
                .postIndex(postIndex)
                .memId(memId)
                .categoryName(categoryName)
                .title(title)
                .content(content)
                .like(like)
                .postDate(postDate)
                .build();
    }
}
