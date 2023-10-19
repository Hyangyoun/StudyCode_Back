package com.STC.StudyCode.Dto;

import com.STC.StudyCode.Entity.RepositoryEntity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RepositoryDto {

    private String fileName;
    private String folderName;
    private String memId;
    private int postIndex;
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
