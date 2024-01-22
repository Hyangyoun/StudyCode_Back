package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Entity.Id.PostLikeId;
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
@IdClass(PostLikeId.class)
@Table(name = "PostLike")
public class PostLikeEntity {
    @Id
    @Column(name = "mem_id")
    private String memId;
    @Id
    @Column(name = "post_index")
    private Integer postIndex;
}
