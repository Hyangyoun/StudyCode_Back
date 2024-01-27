package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Entity.Id.PostListId;
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
@IdClass(PostListId.class)
@Table(name = "PostLike")
public class PostLike {
    @Id
    @Column(name = "mem_id")
    private String memId;
    @Id
    @Column(name = "post_index")
    private Integer postIndex;
}