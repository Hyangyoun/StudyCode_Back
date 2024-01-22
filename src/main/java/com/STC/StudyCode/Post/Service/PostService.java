package com.STC.StudyCode.Post.Service;

import com.STC.StudyCode.Blog.Dto.PostLikeDto;
import com.STC.StudyCode.Blog.Dto.RepositoryDto;
import com.STC.StudyCode.Entity.PostReplyEntity;
import com.STC.StudyCode.Post.Dto.*;

import java.util.List;
import java.util.Set;

public interface PostService {
    List<PostListDto> PostList(String nickname);
    List<PostListDto> PostList(String nickname, String categoryName);
    List<PostListDto> PostTagList(String nickname, String tagName);
    PostInfoDto PostInfo(Integer postIndex);
    Set<Object> TagList(String nickname);
    Integer RegistPost(PostDto postDto);
    void RegistTag(List<PostTagDto> postTagDtos);
    void RegistFile(RepositoryDto repositoryDto);
    List<CommentDto> getComment(Integer postIndex);
    void RegistComment(PostCommentDto postCommentDto);
    void RegistReply(PostReplyDto postReplyDto);
    void LikePost(PostLikeDto postLikeDto);
}
