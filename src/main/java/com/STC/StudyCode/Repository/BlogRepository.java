package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {
}
