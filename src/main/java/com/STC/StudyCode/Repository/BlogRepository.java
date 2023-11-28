package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BlogRepository extends JpaRepository<BlogEntity, String> {
    @Query("select b from BlogEntity b join MemberEntity m on m.memId = b.memId where m.nickname = :nickname")
    Optional<BlogEntity> GetBlogInfo(@Param("nickname") String nickname);
}
