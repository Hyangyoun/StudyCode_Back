package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Dto.RepFolderDto;
<<<<<<< HEAD
import com.STC.StudyCode.Entity.Id.RepFolder;
=======
>>>>>>> main
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD
@IdClass(RepFolder.class)
=======
>>>>>>> main
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


