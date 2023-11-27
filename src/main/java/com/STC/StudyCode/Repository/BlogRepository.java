package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Dto.BlogInfo;
import com.STC.StudyCode.Entity.BlogEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BlogRepository extends JpaRepository<BlogEntity, String> {
    @Query("select b.name as blogName, b.skin as blogSkin, b.followers as followers, b.overview as overview, m.nickname as nickName " +
            "from BlogEntity b join MemberEntity m on b.memId = m.memId where m.nickname = :nickName")
    BlogInfo findBlogInfo(@Param("nickName") String nickName);

    @Transactional
    @Modifying
    @Query("update BlogEntity b set b.overview = :overview where b.memId = :memId")
    void registOverview(@Param("memId") String memId, @Param("overview") String overview);
}
