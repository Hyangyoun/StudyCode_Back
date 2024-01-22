package com.STC.StudyCode.Blog.Dto;

import com.STC.StudyCode.Entity.PostLikeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostLikeDto {
    private String memId;
    private Integer postIndex;

    public PostLikeEntity toEntity() {
        return PostLikeEntity.builder()
                .memId(memId)
                .postIndex(postIndex)
                .build();
    }
}
