package com.STC.StudyCode.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "tag_index")
    private Integer tagIndex;
    @Column(name = "tag_name")
    private String tagName;
}