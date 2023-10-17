package com.STC.StudyCode.Controller;

import com.STC.StudyCode.Dto.BlogDto;
import com.STC.StudyCode.Dto.OverviewDto;
import com.STC.StudyCode.Dto.PostDto;
import com.STC.StudyCode.Dto.RepFolderDto;
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

    /** 블로그 정보 요청 */
     @PostMapping(value = "/info")
     public BlogDto BlogInfo(@RequestParam String memId) {
        return blogService.GetBlogInfo(memId);
     }

     /** 블로그 소개글 등록 */
    @PostMapping(value = "/regist/overview")
    public String RegistOverview(@RequestBody OverviewDto overviewDto) {
        return blogService.RegistOverview(overviewDto);
    }

    /** 블로그 포스트 목록 */
    @PostMapping(value = "/post/list")
    public List<PostDto> PostList(@RequestParam String memId) {
        return blogService.PostList(memId);
    }

    /** 저장소 폴더 등록 */
    @PostMapping(value = "/regist/repo")
    public String RegistRepo(@RequestBody RepFolderDto repFolderDto) {
        return blogService.RegistRepo(repFolderDto);
    }

    /** 저장소 폴더목록 요청 */
    @PostMapping(value = "/get/repo")
    public List<RepFolderDto> GetRepo(@RequestParam String memId) {
        return blogService.GetRepo(memId);
    }
}
