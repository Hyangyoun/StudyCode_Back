package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.PostTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostTagRepository extends JpaRepository<PostTagEntity, Long> {
    @Query("select t.tagName from PostTagEntity t join PostToPostTagEntity ts on ts.tag.tagIndex = t.tagIndex where ts.post.postIndex = :postIndex")
    List<String> PostInfoTag(@Param("postIndex") Long postIndex);
}
