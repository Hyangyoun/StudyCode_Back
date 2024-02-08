package com.STC.StudyCode.Post.Service;

import com.STC.StudyCode.Post.Dto.*;

import java.util.List;

public interface PostService {
    PostToTagInfoDto PostInfo(Long postIndex);
    List<PostToTagInfoDto> PostList(Long blogIndex);
    List<PostToTagInfoDto> PostList(Long blogIndex, Long categoryIndex);
    void test(Long postIndex);
    List<PostToTagInfoDto> TagToPostList(Long blogIndex, String tagName);
    List<CommentListDto> CommentList(Long postIndex);
    void RegistComment(RegistCommentDto registCommentDto);
    void RegistReply(RegistCommentDto registCommentDto);

    Long RegistPost(PostDto postDto);
    void PostFile(List<FileDataDto> fileDataDtos, Long postIndex, Long blogIndex);
    void PostThumbnail(String thumbnailPath, Long postIndex);
    void PostTag(List<String> tags, Long postIndex, Long blogIndex);

}
