package com.STC.StudyCode.Controller;

import com.STC.StudyCode.Dto.BlogDto;
import com.STC.StudyCode.Dto.OverviewDto;
import com.STC.StudyCode.Dto.PostDto;
import com.STC.StudyCode.Service.BlogService;
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

     @PostMapping(value = "/info")
     public BlogDto BlogInfo(@RequestParam String memId) {
        return blogService.GetBlogInfo(memId);
     }

    @PostMapping(value = "/overview")
    public String RegistOverview(@RequestBody OverviewDto overviewDto) {
        return blogService.RegistOverview(overviewDto);
    }

    @PostMapping(value = "/post/list")
    public List<PostDto> PostList(@RequestParam String memId) {
        return blogService.PostList(memId);
    }
}
