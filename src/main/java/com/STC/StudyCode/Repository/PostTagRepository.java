package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.PostTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostTagRepository extends JpaRepository<PostTagEntity, Long> {
    @Query("select t.tagName from PostTagEntity t join PostToPostTagEntity ts on ts.tagIndex = t.tagIndex where ts.postIndex = :postIndex")
    List<String> PostInfoTag(@Param("postIndex") Long postIndex);

    @Query("select distinct t.tagName from PostTagEntity t join PostToPostTagEntity pt on pt.tagIndex = t.tagIndex " +
            "where pt.blogIndex = :blogIndex")
    List<String> BlogTagList(@Param("blogIndex") Long blogIndex);

    boolean existsByTagName(String tagName);
    @Query("select t.tagIndex from PostTagEntity t where t.tagName = :tagName")
    Long GetTagId(@Param("tagName") String tagName);
}
