package com.STC.StudyCode.Post.Dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CommentListDto {
    private Long commentIndex;
    private String content;
    private String commentDate;
    private String nickname;
    private String profilePath;
    private List<ReplyDto> reply;
}
