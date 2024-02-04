package com.STC.StudyCode.Post.Service;

import com.STC.StudyCode.Post.Dto.PostInfoDto;
import com.STC.StudyCode.Post.Dto.PostToTagInfoDto;

import java.util.List;

public interface PostService {
    PostToTagInfoDto PostInfo(Long postIndex);

    List<PostToTagInfoDto> PostList(Long blogIndex);
    void test(Long postIndex);
    List<PostToTagInfoDto> TagToPostList(Long blogIndex, String tagName);
}
