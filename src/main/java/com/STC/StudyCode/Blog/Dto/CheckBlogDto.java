package com.STC.StudyCode.Blog.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckBlogDto {
    private Long blogIndex;
    private boolean self;
}
