package com.STC.StudyCode.Dto;

import com.STC.StudyCode.Entity.RepFolderEntity;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RepFolderDto {
    private String folderName;
    private String memId;

    public RepFolderEntity toEntity() {
        return RepFolderEntity.builder()
                .folderName(folderName)
                .memId(memId)
                .build();
    }
}
