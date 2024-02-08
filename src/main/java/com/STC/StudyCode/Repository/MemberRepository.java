package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

    @Query("select b.blogIndex from MemberEntity m join BlogEntity b on b.memId = m.memId where m.nickname = :nickname")
    Long AccessBlog(@Param("nickname") String nickname);

    @Query("select m.memId from MemberEntity m where m.nickname = :nickname")
    String getMemId(@Param("nickname") String nickname);
}
