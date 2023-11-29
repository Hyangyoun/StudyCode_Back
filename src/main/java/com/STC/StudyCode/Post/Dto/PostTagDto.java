package com.STC.StudyCode.Post.Dto;

import com.STC.StudyCode.Entity.PostTagEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostTagDto {
    private String tagName;
    private Integer postIndex;

    public PostTagEntity toEntity() {
        return PostTagEntity.builder()
                .tagName(tagName)
                .postIndex(postIndex)
                .build();
    }
}
