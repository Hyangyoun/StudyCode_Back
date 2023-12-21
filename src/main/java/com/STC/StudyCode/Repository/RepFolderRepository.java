package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.Id.RepFolderId;
import com.STC.StudyCode.Entity.RepFolderEntity;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepFolderRepository extends JpaRepository<RepFolderEntity, RepFolderId> {
    @Query("select r.folderName from RepFolderEntity r where r.memId = :memId")
    String[] GetFolderList(@Param("memId") String memId);
}
