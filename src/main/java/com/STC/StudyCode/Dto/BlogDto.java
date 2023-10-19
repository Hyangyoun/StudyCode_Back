package com.STC.StudyCode.Dto;

import com.STC.StudyCode.Entity.BlogEntity;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogDto {

    private String memId;
    private String name;
    private int skin;
    private int followers;

    public BlogEntity toEntity() {
        return BlogEntity.builder()
                .memId(memId)
                .name(name)
                .skin(skin)
                .followers(followers)
                .build();
    }
}
