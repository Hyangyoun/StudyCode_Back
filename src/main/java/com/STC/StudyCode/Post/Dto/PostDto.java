package com.STC.StudyCode.Post.Dto;

import com.STC.StudyCode.Entity.PostEntity;
import com.STC.StudyCode.Entity.PostToPostTagEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Integer blogIndex;
    private Integer categoryIndex;
    private String title;
    private String content;
    private Integer recommend;

    public PostEntity toEntity() {
        return PostEntity.builder()
                .blogIndex(blogIndex)
                .categoryIndex(categoryIndex)
                .title(title)
                .content(content)
                .recommend(recommend)
                .build();
    }
}
