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
@Table(name = "Repository")
public class RepositoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_index")
    private Integer fileIndex;
    @Column(name = "parent_index")
    private Integer parentIndex;
    @Column(name = "blog_index")
    private Long blogIndex;
    @Column(name = "post_index")
    private Long postIndex;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_path")
    private String filePath;
    @Enumerated(EnumType.STRING)
    private RepositoryType type;
}
