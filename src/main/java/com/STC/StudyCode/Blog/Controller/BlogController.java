package com.STC.StudyCode.Blog.Controller;

import com.STC.StudyCode.Blog.Dto.BlogDto;
import com.STC.StudyCode.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
