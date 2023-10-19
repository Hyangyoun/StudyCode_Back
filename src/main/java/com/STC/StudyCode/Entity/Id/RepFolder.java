package com.STC.StudyCode.Entity.Id;

import jakarta.persistence.Column;

import java.io.Serializable;

public class RepFolder implements Serializable {
    @Column(name = "folder_name")
    String folderName;
    @Column(name = "mem_id")
    String memId;
}
