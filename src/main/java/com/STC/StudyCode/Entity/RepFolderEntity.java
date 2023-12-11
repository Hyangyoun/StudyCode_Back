package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Entity.Id.RepFolderId;
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
@IdClass(RepFolderId.class)
@Table(name = "RepFolder")
public class RepFolderEntity {
    @Id
    @Column(name = "folder_name")
    private String folderName;
    @Id
    @Column(name = "mem_id")
    private String memId;
}
