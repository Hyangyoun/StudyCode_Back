package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.PostCommentEntity;
import com.STC.StudyCode.Post.Dto.CommentDto;
import com.STC.StudyCode.Post.Dto.ReplyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostCommentEntity, Long> {
    @Query("select c.commentIndex as commentIndex, c.content as content, c.commentDate as commentDate, m.nickname as nickname, m.profilePicture as profilePath" +
            " from PostCommentEntity c join MemberEntity m on m.memId = c.memId where c.postIndex = :postIndex and c.parentIndex = null order by c.commentIndex asc")
    List<CommentDto> CommentList(@Param("postIndex") Long postIndex);

    @Query("select c.commentIndex as commentIndex, c.content as content, c.commentDate as commentDate, m.nickname as nickname, m.profilePicture as profilePath" +
            " from PostCommentEntity c join MemberEntity m on m.memId = c.memId where c.parentIndex = :commentIndex order by c.commentIndex asc")
    List<ReplyDto> ReplyList(@Param("commentIndex") Long commentIndex);
}
