package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Entity.Id.PostTagId;
import com.STC.StudyCode.Post.Dto.PostTagDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(PostTagId.class)
@Table(name = "PostTag")
public class PostTagEntity {
    @Id
    @Column(name = "tag_name")
    private String tagName;
    @Id
    @Column(name = "post_index")
    private Integer postIndex;

    public PostTagDto toDto() {
        return PostTagDto.builder()
                .tagName(tagName)
                .postIndex(postIndex)
                .build();
    }
}
