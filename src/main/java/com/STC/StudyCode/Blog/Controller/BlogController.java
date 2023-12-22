package com.STC.StudyCode.Blog.Controller;

import com.STC.StudyCode.Blog.Dto.BlogConfigDto;
import com.STC.StudyCode.Blog.Dto.BlogDto;
import com.STC.StudyCode.Blog.Dto.CategoryInfoDto;
import com.STC.StudyCode.Blog.Dto.RepositoryFileInfoDto;
import com.STC.StudyCode.Blog.Service.BlogService;
import com.STC.StudyCode.Member.Dto.MemIdDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    /** 레포지토리 폴더 목록 요청 */
    @GetMapping("/repository/folder")
    @Operation(summary = "레포지토리 폴더 목록 요청", description = "블로그 소유자(nickname)의 폴더 목록을 요청합니다.")
    public List<String> FolderList(@RequestParam String nickname) {
        return blogService.FolderList(nickname);
    }

    /** 레포지토리 파일 목록 요청 */
    @GetMapping("/repository/file")
    @Operation(summary = "레포지토리 파일 목록 요청", description = "블로그 소유자(nickname)의 폴더(folderName)에 해당하는 파일 목록을 요청합니다.")
    public List<RepositoryFileInfoDto> FileList(@RequestParam String nickname, @RequestParam String folderName) {
        return blogService.FileList(nickname, folderName);
    }

    /** 카테고리 정보 목록 요청 */
    @Operation(summary = "카테고리 정보 요청", description = "블로그 소유자(nickname)이 등록한 카테고리의 정보를 호출합니다.")
    @GetMapping("/category/info")
    public List<CategoryInfoDto> CategoryInfo(@RequestParam String nickname) {
        return blogService.CategoryInfo(nickname);
    }
}