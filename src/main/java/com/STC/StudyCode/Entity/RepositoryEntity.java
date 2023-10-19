package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Dto.RepositoryDto;
import com.STC.StudyCode.Entity.Id.Repository;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(Repository.class)
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
    private int postIndex;
    @Column(name = "file_path")
    private String filePath;

    public RepositoryDto toDto() {
        return RepositoryDto.builder()
                .fileName(fileName)
                .folderName(folderName)
                .memId(memId)
                .postIndex(postIndex)
                .filePath(filePath)
                .build();
    }
}
