package com.STC.StudyCode.Post.Dto;

import com.STC.StudyCode.Entity.PostEntity;
import com.STC.StudyCode.Entity.PostTagEntity;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private Integer postIndex;
    private String memId;
    private String categoryName;
    private String title;
    private String content;
    private Integer recommend;
    private String postDate;
    private boolean open;
    private String thumbnailPath;

    public PostEntity toEntity() {
        return PostEntity.builder()
                .postIndex(postIndex)
                .memId(memId)
                .categoryName(categoryName)
                .title(title)
                .content(content)
                .recommend(recommend)
                .postDate(postDate)
                .open(open)
                .thumbnailPath(thumbnailPath)
                .build();
    }
}
