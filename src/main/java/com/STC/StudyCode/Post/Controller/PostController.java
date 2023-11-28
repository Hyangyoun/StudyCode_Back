package com.STC.StudyCode.Post.Controller;

import com.STC.StudyCode.Post.Dto.PostListDto;
import com.STC.StudyCode.Service.PostService;
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

    @GetMapping("/list")
    public List<PostListDto> PostList(@RequestParam String nickname) {
        return postService.PostList(nickname);
    }
}
