package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    List<PostEntity> findAllByMemId(String memId);
}
