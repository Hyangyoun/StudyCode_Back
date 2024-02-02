package com.STC.StudyCode.Category.Dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryInfoListDto {
    private String categoryName;
    private Integer postCount;
    private List<String> thumbnailPath;
}
