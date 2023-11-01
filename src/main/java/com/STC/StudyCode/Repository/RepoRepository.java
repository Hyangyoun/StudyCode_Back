package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Dto.PostRepoDto;
import com.STC.StudyCode.Entity.Id.Repository;
import com.STC.StudyCode.Entity.RepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepoRepository extends JpaRepository<RepositoryEntity, Repository> {
    List<RepositoryEntity> findAllByMemId(String memId);

    @Query("select r.fileName as fileName, r.filePath as filePath from RepositoryEntity r where r.postIndex = :postIndex")
    List<PostRepoDto> findFile(@Param("postIndex")int postIndex);
}
