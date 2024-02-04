package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.PostEntity;
import com.STC.StudyCode.Post.Dto.PostInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    Integer countByCategoryIndex(Integer categoryIndex);

    @Query("select p.thumbnailPath from PostEntity p where p.categoryIndex = :categoryIndex order by p.postDate desc limit 4")
    List<String> categoryThumbnail(@Param("categoryIndex") Integer categoryIndex);

    @Query("select p.postIndex as postIndex, p.recommend as recommend, p.title as title, p.content as content, " +
            "p.postDate as postDate, p.thumbnailPath as thumbnailPath " +
            "from PostEntity p where p.postIndex = :postIndex")
    PostInfoDto PostInfo(@Param("postIndex") Long postIndex);

    @Query("select p.postIndex as postIndex, p.recommend as recommend, p.title as title, p.content as content, " +
            "p.postDate as postDate, p.thumbnailPath as thumbnailPath " +
            "from PostEntity p where p.blogIndex = :blogIndex")
    List<PostInfoDto> PostList(@Param("blogIndex") Long blogIndex);
}
