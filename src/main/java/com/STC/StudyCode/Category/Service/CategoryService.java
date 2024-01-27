package com.STC.StudyCode.Category.Service;

import com.STC.StudyCode.Category.Dto.BlogCategoryDto;

public interface CategoryService {
    void CreateCategory(BlogCategoryDto blogCategoryDto);
    void DeleteCategory(BlogCategoryDto blogCategoryDto);
}
