package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Blog.Dto.BlogInfoDto;
import com.STC.StudyCode.Blog.Dto.ConfigInfoDto;
import com.STC.StudyCode.Entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

    Optional<BlogEntity> findByMemId(String memId);

    @Query("select b.name as name, b.skin as skin, b.overview as overview, m.nickname as nickname, m.profilePicture as profilePicture " +
            "from BlogEntity b join MemberEntity m on m.memId = b.memId where b.blogIndex = :blogIndex")
    BlogInfoDto blogInfo(@Param("blogIndex") Long blogIndex);

    @Query("select b.name as name, b.skin as skin, b.overview as overview from BlogEntity b where b.blogIndex = :blogIndex")
    ConfigInfoDto configInfo(@Param("blogIndex") Integer blogIndex);

    @Modifying
    @Transactional
    @Query("update BlogEntity b set b.name = :name, b.skin = :skin, b.overview = :overview where b.blogIndex = :blogIndex")
    void UpdateConfig(@Param("blogIndex") Long blogIndex, @Param("name") String name, @Param("skin") Integer skin, @Param("overview") String overview);
}
