package com.STC.StudyCode.Entity;

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
@Table(name = "PostComment")
public class PostCommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_index")
    private Integer commentIndex;
    @Column(name = "post_index")
    private Integer postIndex;
    @Column(name = "mem_id")
    private String memId;
    private String content;
    @Column(name = "comment_date")
    private String commentDate;

    @OneToMany
    @JoinColumn(name = "comment_index")
    private List<PostReplyEntity> reply;
}
