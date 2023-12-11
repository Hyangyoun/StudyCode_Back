package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Entity.Id.RepositoryId;
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
@IdClass(RepositoryId.class)
@Table(name = "Repository")
public class RepositoryEntity {
    @Id
    @Column(name = "file_name")
    private String fileName;
    @Id
    @Column(name = "folder_name")
    private String folderName;
    @Id
    @Column(name = "mem_id")
    private String memId;
    @Column(name = "post_index")
    private Integer postIndex;
    @Column(name = "file_path")
    private String filePath;
}
