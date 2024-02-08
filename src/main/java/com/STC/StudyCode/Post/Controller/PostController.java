package com.STC.StudyCode.Post.Controller;

import com.STC.StudyCode.Post.Dto.*;
import com.STC.StudyCode.Post.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
        return postService.PostInfo(postIndex);
    }

    @GetMapping("/postList")
    public List<PostToTagInfoDto> postList(@RequestParam Long blogIndex, @RequestParam(required = false) Long categoryIndex) {
        if(categoryIndex != null) {
            return postService.PostList(blogIndex, categoryIndex);
        }
        else return postService.PostList(blogIndex);
    }

    @GetMapping("/tagToList")
    public List<PostToTagInfoDto> postList(@RequestParam Long blogIndex, @RequestParam String tagName) {
        return postService.TagToPostList(blogIndex, tagName);
    }

    @GetMapping("/comment/list")
    public List<CommentListDto> CommentList(@RequestParam Long postIndex) {
        return postService.CommentList(postIndex);
    }

    @PostMapping("/comment/regist")
    public void RegistComment(@RequestBody RegistCommentDto registCommentDto) {
        if(registCommentDto.getComment_index() != null) {
            postService.RegistReply(registCommentDto);
        }
        else postService.RegistComment(registCommentDto);
    }

    @PostMapping("/regist")
    public Long RegistPost(@RequestBody PostDto postDto) {
        return postService.RegistPost(postDto);
    }

    @PostMapping("/data")
    public void PostData(@RequestParam Long postIndex, @RequestParam Long blogIndex, @RequestPart MultipartFile thumbnail,
                         @RequestPart List<MultipartFile> files, @RequestParam List<String> tag) {
        String imgName = thumbnail.getOriginalFilename();
        String saveImgName = "D:/Vsc_work/studycode_front/public/image/thumbnail/" + "_" + imgName;
        String saveDbImgName = "/image/thumbnail/" + "_" + imgName;

        try {
            thumbnail.transferTo(new File(saveImgName));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        List<FileDataDto> fileDataDtos = new ArrayList<FileDataDto>();

        for(MultipartFile multipartFile : files) {
            String fileName = multipartFile.getOriginalFilename();
            String saveFileName = "D:/Vsc_work/studycode_front/public/image/file/" + fileName;
            String saveDbFileName = "/image/file/" + fileName;

            try {
                multipartFile.transferTo((new File(saveFileName)));
                fileDataDtos.add(FileDataDto.builder()
                        .fileName(fileName)
                        .filePath(saveDbFileName)
                        .build());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        postService.PostThumbnail(saveDbImgName, postIndex);
        postService.PostFile(fileDataDtos, postIndex, blogIndex);
        postService.PostTag(tag, postIndex, blogIndex);
    }


    @GetMapping("/test")
    public void test(@RequestParam Long index) {

    }
}
