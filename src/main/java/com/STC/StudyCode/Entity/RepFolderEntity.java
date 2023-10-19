package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Dto.RepFolderDto;
import com.STC.StudyCode.Entity.Id.RepFolder;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(RepFolder.class)
@Table(name = "RepFolder")
public class RepFolderEntity {
    @Id
    @Column(name = "folder_name")
    String folderName;
    @Id
    @Column(name = "mem_id")
    String memId;

    public RepFolderDto toDto() {
        return RepFolderDto.builder()
                .folderName(folderName)
                .memId(memId)
                .build();
    }
}

