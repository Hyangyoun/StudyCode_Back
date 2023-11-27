package com.STC.StudyCode.Dto;

import com.STC.StudyCode.Entity.PostEntity;
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
    private int recommend;
    private Date postDate;

    public PostEntity toEntity() {
        return PostEntity.builder()
                .memId(memId)
                .categoryName(categoryName)
                .title(title)
                .content(content)
                .recommend(recommend)
                .postDate(postDate)
                .build();
    }
}
