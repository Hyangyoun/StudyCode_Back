package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.Id.PostTagId;
import com.STC.StudyCode.Entity.PostTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PostTagRepository extends JpaRepository<PostTagEntity, PostTagId> {
    List<PostTagEntity> findByPostIndex(Integer PostIndex);

    @Query("select t from PostTagEntity t join PostEntity p on p.postIndex = t.postIndex join MemberEntity m " +
            "on m.memId = p.memId where m.nickname = :nickname")
    List<PostTagEntity> GetPostListTag(@Param("nickname") String nickname);

    @Query("select t.tagName from PostTagEntity t join PostEntity p on p.postIndex = t.postIndex " +
            "join MemberEntity m on m.memId = p.memId where m.nickname = :nickname")
    Set<Object> GetTagList(@Param("nickname") String nickname);
}
