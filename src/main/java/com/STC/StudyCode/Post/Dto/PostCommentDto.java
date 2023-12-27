package com.STC.StudyCode.Post.Dto;

import com.STC.StudyCode.Entity.PostCommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostCommentDto {
    private Integer commentIndex;
    private Integer postIndex;
    private String memId;
    private String content;
    private String commentDate;

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
