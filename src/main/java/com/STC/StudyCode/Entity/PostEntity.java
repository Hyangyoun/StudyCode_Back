package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Post.Dto.PostDto;
import com.STC.StudyCode.Post.Dto.PostTagDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Post")
public class PostEntity {
    @Id
    @Column(name = "post_index")
    private Integer postIndex;
    @Column(name = "mem_id")
    private String memId;
    @Column(name = "category_name")
    private String categoryName;
    private String title;
    private String content;
    private Integer recommend;
    @Column(name = "post_date")
    private String postDate;

    public PostDto toDto() {
        return PostDto.builder()
                .postIndex(postIndex)
                .memId(memId)
                .categoryName(categoryName)
                .title(title)
                .content(content)
                .recommend(recommend)
                .postDate(postDate)
                .build();
    }
}
