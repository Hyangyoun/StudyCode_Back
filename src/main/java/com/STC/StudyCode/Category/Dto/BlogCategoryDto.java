package com.STC.StudyCode.Category.Dto;

import com.STC.StudyCode.Entity.BlogCategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogCategoryDto {
    private Integer categoryIndex;
    private String categoryName;
    private Integer blogIndex;

    public BlogCategoryEntity toEntity() {
        return BlogCategoryEntity.builder()
                .categoryIndex(categoryIndex)
                .categoryName(categoryName)
                .blogIndex(blogIndex)
                .build();
    }
}
