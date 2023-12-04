package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Blog.Dto.BlogConfigDto;
import com.STC.StudyCode.Entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BlogRepository extends JpaRepository<BlogEntity, String> {
    @Query("select b from BlogEntity b join MemberEntity m on m.memId = b.memId where m.nickname = :nickname")
    Optional<BlogEntity> GetBlogInfo(@Param("nickname") String nickname);

    @Query("select b.name as name, b.skin as skin from BlogEntity b where b.memId = :memId")
    BlogConfigDto GetBlogOption(@Param("memId") String memId);

    @Modifying
    @Transactional
    @Query("update BlogEntity m set m.overview = :overView where m.memId = :memId")
    void UpdateOverview(@Param("memId") String memId, @Param("overView") String overView);
}
