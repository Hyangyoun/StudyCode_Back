package com.STC.StudyCode.Post.Dto;

import com.STC.StudyCode.Entity.PostReplyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostReplyDto {
    private Integer replyIndex;
    private Integer postIndex;
    private Integer commentIndex;
    private String memId;
    private String content;
    private String commentDate;

    public PostReplyEntity toEntity() {
        return PostReplyEntity.builder()
                .replyIndex(replyIndex)
                .postIndex(postIndex)
                .commentIndex(commentIndex)
                .memId(memId)
                .content(content)
                .commentDate(commentDate)
                .build();
    }
}
