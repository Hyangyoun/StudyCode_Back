package com.STC.StudyCode.Entity.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryId implements Serializable {
    private String fileName;
    private String folderName;
    private String memId;
}
