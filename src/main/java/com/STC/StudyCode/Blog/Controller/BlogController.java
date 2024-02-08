package com.STC.StudyCode.Blog.Controller;

import com.STC.StudyCode.Blog.Dto.*;
import com.STC.StudyCode.Blog.Service.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/info")
    @Operation(summary = "블로그의 기본정보를 받아옵니다.")
    public BlogInfoDto BlogInfo(@RequestParam Long blogIndex) {
        return blogService.BlogInfo(blogIndex);
    }

    @GetMapping("/config")
    @Operation(summary = "블로그의 설정정보를 받아옵니다.")
    public BlogConfigDto BlogConfig(@RequestParam Integer blogIndex) {
        return blogService.BlogConfig(blogIndex);
    }

    @PostMapping("/config/save")
    @Operation(summary = "블로그의 설정정보를 저장합니다.")
    public void SaveConfig(@RequestBody BlogDto blogDto) {
        blogService.SaveConfig(blogDto);
    }

    @GetMapping("/tag")
    public List<String> TagList(@RequestParam Long blogIndex) {
        return blogService.TagList(blogIndex);
    }

    @PostMapping("/regist/overView")
    public void RegistOverview(@RequestBody OverViewDataDto overViewDataDto) {
        blogService.RegistOverView(overViewDataDto);
    }

    @PostMapping("/access")
    public CheckBlogDto AccessBlog(@RequestBody AccessBlogDto accessBlogDto) {
        return blogService.CheckBlog(accessBlogDto);
    }
}
