package com.STC.StudyCode.Dto;

import com.STC.StudyCode.Entity.PostReplyEntity;
import lombok.*;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostReplyDto {
    private Integer replyIndex;
    private Integer postIndex;
    private Integer commentIndex;
    private String memId;
    private String content;
    private Date commentDate;

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
