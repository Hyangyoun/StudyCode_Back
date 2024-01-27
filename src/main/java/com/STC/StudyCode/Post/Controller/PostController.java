package com.STC.StudyCode.Post.Controller;

import com.STC.StudyCode.Entity.PostEntity;
import com.STC.StudyCode.Post.Dto.PostToTagDto;
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

    @GetMapping("/info")
    public List<PostToTagDto> PostInfo(@RequestParam Integer postIndex) {
        return postService.PostInfo(postIndex);
    }

    @GetMapping("/test")
    public PostEntity test(@RequestParam Long index) {
        return postService.test(index);
    }
}
