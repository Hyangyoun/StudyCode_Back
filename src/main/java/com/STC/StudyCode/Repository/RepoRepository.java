package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Blog.Dto.RepositoryFileInfoDto;
import com.STC.StudyCode.Entity.Id.RepositoryId;
import com.STC.StudyCode.Entity.RepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepoRepository extends JpaRepository<RepositoryEntity, RepositoryId> {
    @Query("select r.fileName as fileName, r.postIndex as postIndex, r.filePath as filePath, p.title as postTitle " +
            "from RepositoryEntity r join PostEntity p on p.postIndex = r.postIndex join MemberEntity m on m.memId = r.memId " +
            "where m.nickname = :nickname and r.folderName = :folderName")
    List<RepositoryFileInfoDto> GetFile(@Param("nickname") String nickname, @Param("folderName") String folderName);
}
