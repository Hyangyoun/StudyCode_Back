package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.PostCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostCommentEntity, Integer> {
    List<PostCommentEntity> findAllByPostIndex(Integer postId);
}
