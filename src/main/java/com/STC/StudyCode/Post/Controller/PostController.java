package com.STC.StudyCode.Post.Controller;

import com.STC.StudyCode.Post.Dto.PostInfoDto;
import com.STC.StudyCode.Post.Dto.PostToTagInfoDto;
import com.STC.StudyCode.Post.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/postInfo")
    public PostToTagInfoDto postInfo(@RequestParam Long postIndex) {
        return postService.postInfo(postIndex);
    }

    @GetMapping("/postList")
    public List<PostToTagInfoDto> postList(@RequestParam Long blogIndex) {
        return postService.postList(blogIndex);
    }

    @GetMapping("/test")
    public void test(@RequestParam Long index) {

    }
}
