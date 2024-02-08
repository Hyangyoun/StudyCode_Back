package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.PostToPostTagEntity;
import com.STC.StudyCode.Post.Dto.PostInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostToPostTagRepository extends JpaRepository<PostToPostTagEntity,Long> {
    @Query("select p.postIndex as postIndex, p.recommend as recommend, p.title as title, " +
            "p.content as content, p.postDate as postDate, p.thumbnailPath as thumbnailPath " +
            "from PostToPostTagEntity pt join PostTagEntity t on pt.tagIndex = t.tagIndex join PostEntity p on p.postIndex = pt.postIndex " +
            "where t.tagName = :tagName and pt.blogIndex = :blogIndex")
    List<PostInfoDto> TagToPostList(@Param("blogIndex") Long blogIndex ,@Param("tagName") String tagName);
}
