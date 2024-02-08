package com.STC.StudyCode.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@ToString(of = "tagName")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PostTag")
public class PostTagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_index")
    private Long tagIndex;
    @Column(name = "tag_name")
    private String tagName;
}