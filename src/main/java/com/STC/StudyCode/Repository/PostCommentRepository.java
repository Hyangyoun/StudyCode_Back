package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.PostCommentEntity;
import com.STC.StudyCode.Post.Dto.CommentInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostCommentEntity, Integer> {
    @Query("select c.commentDate as commentDate, c.content as content, c.commentIndex as commentIndex, m.nickname as nickname from PostCommentEntity c " +
            "join MemberEntity m on m.memId = c.memId where c.postIndex = :postIndex")
    List<CommentInfoDto> findComment(@Param("postIndex") Integer postIndex);
}
