package com.STC.StudyCode.Entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Setter
@ToString(of = {"tag"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Post_PostTag")
public class PostToPostTagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pt_index")
    private Long ptIndex;

    @Column(name = "post_index")
    private Long postIndex;

    @Column(name = "tag_index")
    private Long tagIndex;

    @Column(name = "blog_index")
    private Long blogIndex;
}
