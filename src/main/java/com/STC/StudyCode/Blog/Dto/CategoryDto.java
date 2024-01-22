package com.STC.StudyCode.Blog.Dto;

import com.STC.StudyCode.Entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private String categoryName;
    private String memId;

    public CategoryEntity toEntity() {
        return CategoryEntity.builder()
                .categoryName(categoryName)
                .memId(memId)
                .build();
    }
}
