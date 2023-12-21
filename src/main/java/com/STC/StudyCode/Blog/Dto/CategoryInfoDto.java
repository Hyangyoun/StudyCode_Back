package com.STC.StudyCode.Blog.Dto;

import com.STC.StudyCode.Entity.PostEntity;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class CategoryInfoDto {
    private String categoryName;
    private List<String> thumbnailPath;
    private Integer postCount;
}
