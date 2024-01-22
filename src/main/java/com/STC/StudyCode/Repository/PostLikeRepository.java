package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.Id.PostLikeId;
import com.STC.StudyCode.Entity.PostLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLikeEntity, PostLikeId> {
}
