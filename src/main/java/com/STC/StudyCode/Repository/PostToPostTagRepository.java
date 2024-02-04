package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.PostToPostTagEntity;
import com.STC.StudyCode.Post.Dto.PostInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostToPostTagRepository extends JpaRepository<PostToPostTagEntity,Long> {
    @Query("select p.post.postIndex as postIndex, p.post.recommend as recommend, p.post.title as title, " +
            "p.post.content as content, p.post.postDate as postDate, p.post.thumbnailPath as thumbnailPath " +
            "from PostToPostTagEntity p join PostTagEntity t on p.tag.tagIndex = t.tagIndex " +
            "where p.tag.tagName = :tagName and p.blogIndex = :blogIndex")
    List<PostInfoDto> TagToPostList(@Param("blogIndex") Long blogIndex ,@Param("tagName") String tagName);
}
