package com.STC.StudyCode.Post.Service;

import com.STC.StudyCode.Blog.Dto.RepositoryDto;
import com.STC.StudyCode.Entity.PostReplyEntity;
import com.STC.StudyCode.Post.Dto.*;

import java.util.List;

public interface PostService {
    List<PostListDto> PostList(String nickname);
    PostInfoDto PostInfo(Integer postIndex);
    Integer RegistPost(PostDto postDto);
    void RegistTag(List<PostTagDto> postTagDtos);
    void RegistFile(RepositoryDto repositoryDto);
    List<CommentDto> getComment(Integer postIndex);
    void RegistComment(PostCommentDto postCommentDto);
    void RegistReply(PostReplyDto postReplyDto);
}
