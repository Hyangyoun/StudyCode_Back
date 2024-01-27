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
    @Column(name = "file_index")
    private Integer fileIndex;
    @Column(name = "parent_index")
    private Integer parentIndex;
    @Column(name = "blog_index")
    private Integer blogIndex;
    @Column(name = "post_index")
    private Integer postIndex;
    @Column(name = "file_name")
    private Integer fileName;
    @Column(name = "file_path")
    private Integer filePath;
    @Enumerated(EnumType.STRING)
    private RepositoryType type;
}
