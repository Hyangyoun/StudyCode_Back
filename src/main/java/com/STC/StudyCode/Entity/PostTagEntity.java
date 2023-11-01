package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Dto.PostTagDto;
import com.STC.StudyCode.Entity.Id.PostTagId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PostTagId.class)
@Table(name = "PostTag")
public class PostTagEntity {

    @Id
    @Column(name = "tag_name")
    private String tagName;

    @Id
    @Column(name = "post_index")
    private int postIndex;

    public PostTagDto toDto() {
        return PostTagDto.builder()
                .tagName(tagName)
                .postIndex(postIndex)
                .build();
    }
}
