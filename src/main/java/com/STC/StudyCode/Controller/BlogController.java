package com.STC.StudyCode.Controller;

import com.STC.StudyCode.Dto.OverviewDto;
import com.STC.StudyCode.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping(value = "/overview")
    public int RegistOverview(@RequestBody OverviewDto overviewDto) {
        return blogService.RegistOverview(overviewDto);
    }
}
