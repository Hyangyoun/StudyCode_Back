package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Category.Dto.CategoryInfoDto;
import com.STC.StudyCode.Entity.BlogCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogCategoryRepository extends JpaRepository<BlogCategoryEntity, Integer> {
    List<BlogCategoryEntity> findByBlogIndex(Integer blogIndex);

    @Query("select c.categoryIndex as categoryIndex, c.categoryName as categoryName from BlogCategoryEntity c " +
            "where c.blogIndex = :blogIndex")
    List<CategoryInfoDto> CategoryInfo(@Param("blogIndex") Long blogIndex);

    @Modifying
    @Transactional
    @Query("delete from BlogCategoryEntity c where c.categoryName = :categoryName and c.blogIndex = :blogIndex")
    void DeleteCategory(@Param("blogIndex") Integer blogIndex, @Param("categoryName") String categoryName);
}
