package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.PostReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostReplyRepository extends JpaRepository<PostReplyEntity, Integer> {
    List<PostReplyEntity> findAllByPostIndex(Integer postIndex);
}
