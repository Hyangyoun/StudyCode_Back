package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Dto.PostReplyDto;
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
@Table(name = "PostReply")
public class PostReplyEntity {
    @Id
    @Column(name = "reply_index")
    private Integer replyIndex;
    @Column(name = "post_index")
    private Integer postIndex;
    @Column(name = "comment_index")
    private Integer commentIndex;
    @Column(name = "mem_id")
    private String memId;
    private String content;
    @Column(name = "comment_date")
    private Date commentDate;

    public PostReplyDto toDto() {
        return PostReplyDto.builder()
                .replyIndex(replyIndex)
                .postIndex(postIndex)
                .commentIndex(commentIndex)
                .memId(memId)
                .content(content)
                .commentDate(commentDate)
                .build();
    }
}
