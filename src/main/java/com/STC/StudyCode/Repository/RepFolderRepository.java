package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.Id.RepFolderId;
import com.STC.StudyCode.Entity.RepFolderEntity;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepFolderRepository extends JpaRepository<RepFolderEntity, RepFolderId> {
    @Query("select r.folderName from RepFolderEntity r join MemberEntity m on m.memId = r.memId where m.nickname = :nickname")
    List<String> GetFolderList(@Param("nickname") String nickname);
}
