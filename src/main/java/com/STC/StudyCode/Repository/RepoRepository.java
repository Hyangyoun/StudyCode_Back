package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.RepositoryEntity;
import com.STC.StudyCode.Entity.RepositoryType;
import com.STC.StudyCode.Repo.Dto.RepoFileDto;
import com.STC.StudyCode.Repo.Dto.RepoFolderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepoRepository extends JpaRepository<RepositoryEntity, Long> {
    @Query("select r.fileIndex as fileIndex, r.fileName as folderName from RepositoryEntity r where r.blogIndex = :blogIndex and r.type = :type")
    List<RepoFolderDto> FolderList(@Param("blogIndex") Long blogIndex, @Param("type") RepositoryType repositoryType);

    @Query("select r.fileName as fileName, r.filePath as filePath, r.postIndex as postIndex, p.title as postTitle " +
            "from RepositoryEntity r join PostEntity p on p.postIndex = r.postIndex where r.blogIndex = :blogIndex and r.parentIndex = :fileIndex and r.type = :type")
    List<RepoFileDto> FileList(@Param("blogIndex") Long blogIndex, @Param("fileIndex") Long fileIndex, @Param("type") RepositoryType repositoryType);

    @Query("select r.fileName as fileName, r.filePath as filePath, r.postIndex as postIndex, p.title as postTitle " +
            "from RepositoryEntity r join PostEntity p on p.postIndex = r.postIndex where r.blogIndex = :blogIndex and r.parentIndex = null and r.type = :type")
    List<RepoFileDto> FileList(@Param("blogIndex") Long blogIndex, @Param("type") RepositoryType repositoryType);
}
