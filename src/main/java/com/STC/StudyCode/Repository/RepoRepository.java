package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.Id.Repository;
import com.STC.StudyCode.Entity.RepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoRepository extends JpaRepository<RepositoryEntity, Repository> {
    List<RepositoryEntity> findAllByMemId(String memId);
}
