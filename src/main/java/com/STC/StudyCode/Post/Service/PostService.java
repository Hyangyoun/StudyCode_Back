package com.STC.StudyCode.Post.Service;

import com.STC.StudyCode.Post.Dto.PostInfoDto;
import com.STC.StudyCode.Post.Dto.PostToTagInfoDto;

import java.util.List;

public interface PostService {
    PostToTagInfoDto postInfo(Long postIndex);

    List<PostToTagInfoDto> postList(Long blogIndex);
    void test(Long postIndex);
}
