package com.STC.StudyCode.Blog.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogConfigDto {
    private String name;
    private Integer skin;
    private String overview;
    private List<String> categoryList;
}
