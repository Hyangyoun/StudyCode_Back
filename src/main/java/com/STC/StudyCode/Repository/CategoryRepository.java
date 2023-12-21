package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Blog.Dto.CategoryInfoDto;
import com.STC.StudyCode.Entity.CategoryEntity;
import com.STC.StudyCode.Entity.Id.CategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, CategoryId> {
    @Query("select c from CategoryEntity c join MemberEntity m on m.memId = c.memId where m.nickname = :nickname")
    List<CategoryEntity> findCategory(@Param("nickname") String nickname);
}
