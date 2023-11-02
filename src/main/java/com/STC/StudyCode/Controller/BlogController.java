package com.STC.StudyCode.Controller;

import com.STC.StudyCode.Dto.*;
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

    /** 블로그 소개글 요청 */
    @PostMapping(value = "/get/overview")
    public OverviewDto GetOverview(@RequestParam String memId) {
        return blogService.GetOverview(memId);
    }

    /** 블로그 포스트 목록 */
    @PostMapping(value = "/get/post/list")
    public List<PostListDto> PostList(@RequestParam String memId) {
        return blogService.PostList(memId);
    }

    /** 포스트 정보 요청 */
    @PostMapping(value = "/get/post/info")
    public PostDto PostInfo(@RequestParam int postIndex) {
        return blogService.PostInfo(postIndex);
    }

    /** 포스트 태그 목록 요청 */
    @PostMapping(value = "/get/post/tag")
    public List<PostTagListDto> PostTag(@RequestParam int postIndex) {
        return blogService.PostTagList(postIndex);
    }

    /** 포스트 파일 목록 요청 */
    @PostMapping("/get/post/file")
    public List<PostRepoDto> PostRepo(@RequestParam int postIndex) {
        return blogService.PostRepoList(postIndex);
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

    /** 저장소 파일 등록 */
    @PostMapping(value = "/regist/file")
    public String RegistFile(@RequestBody RepositoryDto repositoryDto) {
        return blogService.RegistFile(repositoryDto);
    }

    /** 저장소 파일목록 요청 */
    @PostMapping(value = "/get/file")
    public List<RepositoryDto> GetFile(@RequestParam String memId) {
        return blogService.GetFile(memId);
    }

    /** 댓글 목록 요청 */
    @PostMapping(value = "/get/post/comment")
    public List<Object> GetComment(@RequestParam Integer postIndex) {
        return blogService.GetComment(postIndex);
    }
}
