package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.Id.RepFolder;
import com.STC.StudyCode.Entity.RepFolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepFolderRepository extends JpaRepository<RepFolderEntity, RepFolder> {
    List<RepFolderEntity> findAllByMemId(String memId);
}
