package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.PostEntity;
import com.STC.StudyCode.Post.Dto.PostInfoDto;
import com.STC.StudyCode.Post.Dto.PostListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    @Query("select p.postIndex as postIndex, p.title as title, p.content as content, p.recommend as recommend, " +
            "p.postDate as postDate from PostEntity p join MemberEntity m on m.memId = p.memId where m.nickname = :nickname")
    List<PostListDto> GetPostList(@Param("nickname") String nickname);

    @Query("select p.title as title, p.content as content, p.recommend as recommend, p.postDate as postDate, " +
            "m.nickname as nickname, b.name as blogName from PostEntity p join MemberEntity m on m.memId = p.memId join BlogEntity b on b.memId = p.memId where p.postIndex = :postIndex")
    PostInfoDto GetPostInfo(@Param("postIndex") Integer postIndex);
}
