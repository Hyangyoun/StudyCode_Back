package com.STC.StudyCode.Dto;

import com.STC.StudyCode.Entity.PostCommentEntity;
import lombok.*;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostCommentDto {
    private Integer commentIndex;
    private Integer postIndex;
    private String memId;
    private String content;
    private Date commentDate;

    public PostCommentEntity toEntity() {
        return PostCommentEntity.builder()
                .commentIndex(commentIndex)
                .postIndex(postIndex)
                .memId(memId)
                .content(content)
                .commentDate(commentDate)
                .build();
    }
}
