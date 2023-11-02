package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Dto.PostCommentDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PostComment")
public class PostCommentEntity {
    @Id
    @Column(name = "comment_index")
    private Integer commentIndex;
    @Column(name = "post_index")
    private Integer postIndex;
    @Column(name = "mem_id")
    private String memId;
    private String content;
    @Column(name = "comment_date")
    private Date commentDate;

    public PostCommentDto toDto() {
        return PostCommentDto.builder()
                .commentIndex(commentIndex)
                .postIndex(postIndex)
                .memId(memId)
                .content(content)
                .commentDate(commentDate)
                .build();
    }
}
