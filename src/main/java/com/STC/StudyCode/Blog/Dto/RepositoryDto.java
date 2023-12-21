package com.STC.StudyCode.Blog.Dto;

import com.STC.StudyCode.Entity.RepositoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RepositoryDto {
    private String fileName;
    private String folderName;
    private String memId;
    private Integer postIndex;
    private String filePath;

    public RepositoryEntity toEntity() {
        return RepositoryEntity.builder()
                .fileName(fileName)
                .folderName(folderName)
                .memId(memId)
                .postIndex(postIndex)
                .filePath(filePath)
                .build();
    }
}
