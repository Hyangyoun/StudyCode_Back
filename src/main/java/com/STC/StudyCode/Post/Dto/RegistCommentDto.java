package com.STC.StudyCode.Post.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistCommentDto {
    private Long postIndex;
    private String memId;
    private String content;
    private Long comment_index;
}
