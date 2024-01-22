package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.PostEntity;
import com.STC.StudyCode.Post.Dto.PostInfoDto;
import com.STC.StudyCode.Post.Dto.PostUserDto;
import com.STC.StudyCode.Post.Dto.ThumbnailPathDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    /** 포스트 리스트 */
    @Query("select p from PostEntity p join MemberEntity m on m.memId = p.memId where m.nickname = :nickname")
    List<PostEntity> GetPostList(@Param("nickname") String nickname);

    /** 카테고리별 포스트 목록 요청 */
    @Query("select p from PostEntity p join MemberEntity m on m.memId = p.memId where m.nickname = :nickname and p.categoryName = :categoryName")
    List<PostEntity> GetCategoryPostList(@Param("nickname") String nickname, @Param("categoryName") String categoryName);

    @Query("select p from PostEntity p join MemberEntity m on m.memId = p.memId join PostTagEntity t " +
            "on t.postIndex = p.postIndex where m.nickname = :nickname and t.tagName = :tagName")
    List<PostEntity> GetTagPostList(@Param("nickname") String nickname, @Param("tagName") String tagName);

    /** 포스트 상세정보 */
    @Query("select p from PostEntity p where p.postIndex = :postIndex")
    Optional<PostEntity> GetPostInfo(@Param("postIndex") Integer postIndex);

    /** 포스트 유저정보 */
    @Query("select b.name as blogName, m.nickname as nickname from PostEntity p join MemberEntity m on m.memId = p.memId " +
            "join BlogEntity b on b.memId = p.memId where p.postIndex = :postIndex")
    PostUserDto GetPostUser(@Param("postIndex") Integer postIndex);

    /** 카테고리 썸네일 경로 */
    @Query("select p.thumbnailPath as thumbnailPath from PostEntity p join MemberEntity m on m.memId = p.memId " +
            "where p.categoryName = :categoryName and m.nickname = :nickName order by p.postDate desc limit 4")
    List<ThumbnailPathDto> GetCategory(@Param("categoryName") String categoryName, @Param("nickName") String nickName);

    /** 카테고리 포스트 count */
    @Query("select count(p) as thumbnailPath from PostEntity p join MemberEntity m on m.memId = p.memId where p.categoryName = :categoryName and m.nickname = :nickName")
    Integer GetCategorytoCount(@Param("categoryName") String categoryName, @Param("nickName") String nickName);

    /** 포스트 좋아요 증가 */
    @Modifying
    @Transactional
    @Query("update PostEntity p set p.recommend = p.recommend + 1 where p.postIndex = :postIndex")
    void AddLike(@Param("postIndex") Integer postIndex);

    /** 포스트 좋아요 감소 */
    @Modifying
    @Transactional
    @Query("update PostEntity p set p.recommend = p.recommend - 1 where p.postIndex = :postIndex")
    void DeleteLike(@Param("postIndex") Integer postIndex);
}
