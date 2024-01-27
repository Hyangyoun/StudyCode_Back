package com.STC.StudyCode.Category.Service;

import com.STC.StudyCode.Category.Dto.BlogCategoryDto;
import com.STC.StudyCode.Repository.BlogCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
    BlogCategoryRepository blogCategoryRepository;

    @Autowired
    public CategoryServiceImpl(BlogCategoryRepository blogCategoryRepository) {
        this.blogCategoryRepository = blogCategoryRepository;
    }

    @Override
    public void CreateCategory(BlogCategoryDto blogCategoryDto) {
        blogCategoryRepository.save(blogCategoryDto.toEntity());
    }

    @Override
    public void DeleteCategory(BlogCategoryDto blogCategoryDto) {
        blogCategoryRepository.DeleteCategory(blogCategoryDto.getBlogIndex(), blogCategoryDto.getCategoryName());
    }
}
