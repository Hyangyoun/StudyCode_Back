package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.Id.RepositoryId;
import com.STC.StudyCode.Entity.RepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoRepository extends JpaRepository<RepositoryEntity, RepositoryId> {
}
