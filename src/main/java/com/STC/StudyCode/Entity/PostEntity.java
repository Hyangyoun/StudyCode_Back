package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Post.Dto.PostDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
