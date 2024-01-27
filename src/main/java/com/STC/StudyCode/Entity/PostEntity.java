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
@Table(name = "Post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_index")
    private Integer postIndex;
    @Column(name = "blog_index")
    private Integer blogIndex;
    @Column(name = "category_index")
    private Integer categoryIndex;
    private String title;
    private String content;
    private Integer recommend;
    @Column(name = "post_date")
    private String postDate;
    @OneToMany(mappedBy = "post")
    private List<PostToPostTagEntity> tags;
}
