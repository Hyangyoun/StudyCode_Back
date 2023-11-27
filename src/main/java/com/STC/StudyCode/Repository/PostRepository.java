package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Dto.PostInfoDto;
import com.STC.StudyCode.Dto.PostListDto;
import com.STC.StudyCode.Entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    @Query("select p.postIndex as postIndex, p.title as title, p.content as content, p.recommend as recommend, p.postDate as date " +
            "from PostEntity p where p.memId = :memId")
    List<PostListDto> findPostList(@Param("memId") String memId);

    @Query("select m.nickname as nickName, b.name as blogName, p.title as title, p.content as content, p.recommend as recommend, p.postDate as postDate, p.categoryName as categoryName " +
            "from PostEntity p join MemberEntity m on p.memId = m.memId join BlogEntity b on p.memId = b.memId where p.postIndex = :postIndex")
    PostInfoDto findPostInfo(@Param("postIndex") int postIndex);
}
