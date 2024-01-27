package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.BlogCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogCategoryRepository extends JpaRepository<BlogCategoryEntity, Integer> {
    List<BlogCategoryEntity> findByBlogIndex(Integer blogIndex);

    @Modifying
    @Transactional
    @Query("delete from BlogCategoryEntity c where c.categoryName = :categoryName and c.blogIndex = :blogIndex")
    void DeleteCategory(@Param("blogIndex") Integer blogIndex, @Param("categoryName") String categoryName);
}
