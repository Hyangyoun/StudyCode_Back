package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.PostReplyEntity;
import com.STC.StudyCode.Post.Dto.ReplyInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostReplyRepository extends JpaRepository<PostReplyEntity, Integer> {
    @Query("select r.content as content, r.commentDate as commentDate, m.nickname as nickname from PostReplyEntity r " +
            "join MemberEntity m on m.memId = r.memId where r.commentIndex = :commentIndex")
    List<ReplyInfoDto> findReply(@Param("commentIndex") Integer commentIndex);
}
