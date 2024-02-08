package com.STC.StudyCode.Post.Dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostToTagInfoDto {
    private Long postIndex;
    private String title;
    private String content;
    private Integer recommend;
    private String postDate;
    private String thumbnailPath;
    private String nickname;
    private String blogName;
    private List<String> tag;
}
