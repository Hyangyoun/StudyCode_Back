package com.STC.StudyCode.Dto;

import com.STC.StudyCode.Entity.OverviewEntity;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OverviewDto {

    int blogIndex;
    String content;

    public OverviewEntity toEntity() {
        return OverviewEntity.builder()
                .blogIndex(blogIndex)
                .content(content)
                .build();
    }
}
