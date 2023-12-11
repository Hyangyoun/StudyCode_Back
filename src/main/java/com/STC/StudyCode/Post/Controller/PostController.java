package com.STC.StudyCode.Post.Controller;

import com.STC.StudyCode.Post.Dto.PostDto;
import com.STC.StudyCode.Post.Dto.PostInfoDto;
import com.STC.StudyCode.Post.Dto.PostListDto;
import com.STC.StudyCode.Post.Dto.PostTagDto;
import com.STC.StudyCode.Post.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list/tag")
    public List<PostTagDto> PostListTag(@RequestParam String nickname) {
        return postService.PostListTag(nickname);
    }

    @GetMapping("/info")
    public PostInfoDto PostInfo(@RequestParam Integer postIndex) {
        return postService.PostInfo(postIndex);
    }

    @GetMapping("/info/tag")
    public List<PostTagDto> PostTag(@RequestParam Integer postIndex) {
        return postService.PostTag(postIndex);
    }

    @PostMapping("/regist")
    public Integer RegistPost(@RequestBody PostDto postDto) {
        return postService.RegistPost(postDto);
    }

    @PostMapping("/regist/tag")
    public void RegistTag(@RequestBody List<PostTagDto> postTagDtos) {
        postService.RegistTag(postTagDtos);
    }
}
