package com.STC.StudyCode.Blog.Controller;

import com.STC.StudyCode.Blog.Dto.BlogConfigDto;
import com.STC.StudyCode.Blog.Dto.BlogDto;
import com.STC.StudyCode.Blog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/info")
    public BlogDto BlogInfo(@RequestParam String nickname) {
        return blogService.BlogInfo(nickname);
    }

    @PostMapping("/config")
    public BlogConfigDto BlogConfig(@RequestBody Map<String, String> memIdMap) {
        return blogService.BlogConfig(memIdMap.get("memId"));
    }
}
