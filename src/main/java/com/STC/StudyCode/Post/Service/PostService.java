package com.STC.StudyCode.Post.Service;

import com.STC.StudyCode.Post.Dto.PostDto;
import com.STC.StudyCode.Post.Dto.PostInfoDto;
import com.STC.StudyCode.Post.Dto.PostListDto;
import com.STC.StudyCode.Post.Dto.PostTagDto;

import java.util.List;

public interface PostService {
    List<PostListDto> PostList(String nickname);
    List<PostTagDto> PostListTag(String nickname);
    PostInfoDto PostInfo(Integer postIndex);
    List<PostTagDto> PostTag(Integer postIndex);

    PostDto Test(Integer postIndex);
}
