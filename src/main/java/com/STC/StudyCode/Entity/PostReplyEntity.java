package com.STC.StudyCode.Entity;

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
@Table(name = "PostReply")
public class PostReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String commentDate;
}
