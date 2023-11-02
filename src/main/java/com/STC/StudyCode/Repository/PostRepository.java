package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Dto.PostListDto;
import com.STC.StudyCode.Entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    @Query("select p.postIndex as postIndex, p.title as title, p.content as content, p.like as like, p.postDate as date " +
            "from PostEntity p where p.memId = :memId")
    List<PostListDto> findPostList(@Param("memId") String memId);

}
