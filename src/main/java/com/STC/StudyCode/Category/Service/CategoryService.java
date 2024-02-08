package com.STC.StudyCode.Category.Service;

import com.STC.StudyCode.Category.Dto.BlogCategoryDto;
import com.STC.StudyCode.Category.Dto.CategoryInfoDto;
import com.STC.StudyCode.Category.Dto.CategoryInfoListDto;

import java.util.List;

public interface CategoryService {
    void CreateCategory(BlogCategoryDto blogCategoryDto);
    void DeleteCategory(BlogCategoryDto blogCategoryDto);
    List<CategoryInfoDto> CategoryList(Long blogIndex);
    List<CategoryInfoListDto> CategoryInfo(Long blogIndex);
}
