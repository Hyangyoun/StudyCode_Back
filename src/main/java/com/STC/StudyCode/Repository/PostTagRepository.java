package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Dto.PostTagListDto;
import com.STC.StudyCode.Entity.Id.PostTagId;
import com.STC.StudyCode.Entity.PostTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostTagRepository extends JpaRepository<PostTagEntity, PostTagId> {
    @Query("select t.tagName as tagName from PostTagEntity t where t.postIndex = :postIndex")
    List<PostTagListDto> getTagName(@Param("postIndex") int postIndex);
}
