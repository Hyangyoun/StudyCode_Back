package com.STC.StudyCode.Category.Controller;

import com.STC.StudyCode.Category.Dto.BlogCategoryDto;
import com.STC.StudyCode.Category.Service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    @Operation(summary = "카테고리를 추가합니다.", description = "해당 블로그에 카테고리를 추가합니다.")
    public void CreateCategory(@RequestBody BlogCategoryDto blogCategoryDto) {
        categoryService.CreateCategory(blogCategoryDto);
    }

    @PostMapping("/delete")
    @Operation(summary = "카테고리를 삭제합니다.", description = "해당 블로그에 카테고리를 삭제합니다.")
    public void DeleteCategory(@RequestBody BlogCategoryDto blogCategoryDto) {
        categoryService.DeleteCategory(blogCategoryDto);
    }

}
