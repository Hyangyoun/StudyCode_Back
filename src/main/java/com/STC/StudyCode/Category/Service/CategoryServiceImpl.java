package com.STC.StudyCode.Category.Service;

import com.STC.StudyCode.Category.Dto.BlogCategoryDto;
import com.STC.StudyCode.Category.Dto.CategoryInfoDto;
import com.STC.StudyCode.Category.Dto.CategoryInfoListDto;
import com.STC.StudyCode.Repository.BlogCategoryRepository;
import com.STC.StudyCode.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    BlogCategoryRepository blogCategoryRepository;
    PostRepository postRepository;

    @Autowired
    public CategoryServiceImpl(BlogCategoryRepository blogCategoryRepository, PostRepository postRepository) {
        this.blogCategoryRepository = blogCategoryRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void CreateCategory(BlogCategoryDto blogCategoryDto) {
        blogCategoryRepository.save(blogCategoryDto.toEntity());
    }

    @Override
    public void DeleteCategory(BlogCategoryDto blogCategoryDto) {
        blogCategoryRepository.DeleteCategory(blogCategoryDto.getBlogIndex(), blogCategoryDto.getCategoryName());
    }

    @Override
    public List<CategoryInfoListDto> CategoryInfo(Long blogIndex) {
        List<CategoryInfoDto> categoryInfos = blogCategoryRepository.CategoryInfo(blogIndex);
        List<CategoryInfoListDto> categoryInfoListDtos = new ArrayList<CategoryInfoListDto>();

        for(CategoryInfoDto categoryInfoDto : categoryInfos) {
            categoryInfoListDtos.add(CategoryInfoListDto.builder()
                    .categoryName(categoryInfoDto.getCategoryName())
                    .postCount(postRepository.countByCategoryIndex(categoryInfoDto.getCategoryIndex()))
                    .thumbnailPath(postRepository.categoryThumbnail(categoryInfoDto.getCategoryIndex()))
                    .build());
        }

        return categoryInfoListDtos;
    }
}
