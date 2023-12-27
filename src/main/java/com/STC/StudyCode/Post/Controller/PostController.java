package com.STC.StudyCode.Post.Controller;

import com.STC.StudyCode.Post.Dto.*;
import com.STC.StudyCode.Post.Service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    /** 포스트 리스트 정보 요청 */
    @Operation(summary = "포스트 리스트 정보 요청", description = "블로그 소유자(nickname)이 등록한 포스트의 리스트를 호출합니다.")
    @GetMapping("/list")
    public List<PostListDto> PostList(@RequestParam String nickname) {
        return postService.PostList(nickname);
    }

    /** 포스트 상세 정보 요청 */
    @Operation(summary = "포스트 상세 정보 요청", description = "포스트Index에 해당하는 포스트의 정보를 호출합니다.")
    @GetMapping("/info")
    public PostInfoDto PostInfo(@RequestParam Integer postIndex) {
        return postService.PostInfo(postIndex);
    }

    /** 포스트 등록 */
    @Operation(summary = "포스트 등록", description = "작성한 포스트를 등록합니다.")
    @PostMapping("/regist")
    public Integer RegistPost(@RequestBody PostDto postDto) {
        return postService.RegistPost(postDto);
    }

    /** 포스트 태그 등록 */
    @Operation(summary = "포스트 태그 등록", description = "작성한 포스트의 태그를 등록합니다.")
    @PostMapping("/regist/tag")
    public void RegistTag(@RequestBody List<PostTagDto> postTagDtos) {
        postService.RegistTag(postTagDtos);
    }

    /** 포스트 파일 등록 */
    @Operation(summary = "포스트 파일 등록(미완)", description = "작성한 포스트의 파일을 등록합니다.")
    @PostMapping("/regist/file")
    public void RegistFile(@RequestPart MultipartFile[] multipartFiles) {

    }

    /** 포스트 댓글 요청 */
    @Operation(summary = "포스트 댓글정보 요청", description = "postIndex에 해당하는 포스트의 댓글목록을 요청합니다.")
    @GetMapping("/comment")
    public List<CommentDto> getComment(@RequestParam Integer postIndex) {
        return postService.getComment(postIndex);
    }

    /** 포스트 댓글 등록 */
    @Operation(summary = "포스트 댓글 등록", description = "댓글을 등록합니다.")
    @GetMapping("/regist/comment")
    public void RegistComment(@RequestParam PostCommentDto postCommentDto) {
        postService.RegistComment(postCommentDto);
    }

    /** 포스트 대댓글 등록 */
    @Operation(summary = "포스트 대댓글 등록", description = "대댓글을 등록합니다.")
    @GetMapping("/regist/reply")
    public void RegistReply(@RequestParam PostReplyDto postReplyDto) {
        postService.RegistReply(postReplyDto);
    }
}
