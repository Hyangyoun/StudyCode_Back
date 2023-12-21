package com.STC.StudyCode.Blog.Controller;

import com.STC.StudyCode.Blog.Dto.BlogConfigDto;
import com.STC.StudyCode.Blog.Dto.BlogDto;
import com.STC.StudyCode.Blog.Service.BlogService;
import com.STC.StudyCode.Member.Dto.MemIdDto;
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

    /** 블로그 정보 */
    @GetMapping("/info")
    public BlogDto BlogInfo(@RequestParam String nickname) {
        return blogService.BlogInfo(nickname);
    }

    /** 블로그 설정 */
    @PostMapping("/config")
    public BlogConfigDto BlogConfig(@RequestBody MemIdDto memIdDto) {
        return blogService.BlogConfig(memIdDto.getMemId());
    }

    /** 오버뷰 등록 */
    @PostMapping("/regist/overView")
    public void RegistOverview(@RequestBody Map<String, String> overViewMap) {
        blogService.RegistOverview(overViewMap.get("memId"), overViewMap.get("overView"));
    }

    /** 블로그 설정 저장 */
    @PostMapping("/config/update")
    public void SaveBlogConfig(@RequestBody BlogDto blogDto) {
        blogService.SaveBlogConfig(blogDto);
    }
}
