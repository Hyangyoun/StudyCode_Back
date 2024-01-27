package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.PostToPostTagEntity;
import com.STC.StudyCode.Post.Dto.PostToTagDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostToPostTagRepository extends JpaRepository<PostToPostTagEntity,Long> {
    @Query("select pt.post as post, pt.tag as tag from PostToPostTagEntity pt where pt.post.postIndex = :postIndex")
    List<PostToTagDto> PostInfo(@Param("postIndex") Integer postIndex);
}
