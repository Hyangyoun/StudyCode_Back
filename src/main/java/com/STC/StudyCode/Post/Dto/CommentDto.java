package com.STC.StudyCode.Post.Dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CommentDto {
    private Integer commentIndex;
    private String nickname;
    private String content;
    private String commentDate;
    private List<ReplyInfoDto> reply;
}
