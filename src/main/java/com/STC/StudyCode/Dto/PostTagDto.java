package com.STC.StudyCode.Dto;

import com.STC.StudyCode.Entity.PostTagEntity;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostTagDto {
    private String tagName;
    private int postIndex;

    public PostTagEntity toEntity() {
        return PostTagEntity.builder()
                .tagName(tagName)
                .postIndex(postIndex)
                .build();
    }
}
