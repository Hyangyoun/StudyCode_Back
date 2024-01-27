package com.STC.StudyCode.Blog.Dto;

import com.STC.StudyCode.Entity.BlogEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogDto {
    private Integer blogIndex;
    private String memId;
    private String name;
    private Integer skin;
    private String overview;

    public BlogEntity toEntity() {
        return BlogEntity.builder()
                .blogIndex(blogIndex)
                .memId(memId)
                .name(name)
                .skin(skin)
                .overview(overview)
                .build();
    }
}
